#!/bin/bash

print_usage ()
{
	echo "You must pass to the script the following parameters in the displayed order:"
	echo " IMAGE_NAME : the name of the image you want to flash"
	echo " MACHINE_NAME : the name of the machine used to build the specified image"
	echo "  (MACHINE parameter set in bitbake)"
	echo " PATH_TO_BUILDDIR : the (relative or absolute) path of the Yocto building directory"
	echo "  containing the specified image"
	echo "For example:"
	echo " ./deploy-aaeon.sh core-image-minimal jetson-nano-qspi-sd ../../../my-build"
}


[ $# -ne 3 ] && print_usage && exit 1
image=$1
machine=$2
builddir=$3

deployfile=${image}-${machine}.tegraflash.tar.gz
tmpdir=`mktemp`

builddir=$(realpath "$builddir")
rm -rf $tmpdir
mkdir -p $tmpdir
echo "Using temp directory $tmpdir"
pushd $tmpdir
cp ${builddir}/tmp/deploy/images/${machine}/$deployfile .
tar -xvf $deployfile
set -e
sudo ./doflash.sh
popd
echo "Removing temp directory $tmpdir"
sudo rm -rf $tmpdir
