# Copyright (C) 2020 Koan Software - Bergamo (Italy)

FILESEXTRAPATHS_prepend_jetson-xavier-nx-devkit-emmc := "${THISDIR}/files:"

# TODO: use patch to modify original dts to enable uSD card reader
# The only thing that have to be reverse-engineered is the vmmc-supply,
# should be the one named "vdd-3v3-cvb" (p3668_vdd_3v3_cvb is not existent, maybe p3509_vdd_3v3_cvb?)
# SRC_URI_append_jetson-xavier-nx-devkit-emmc = "file://0000-enable-sdmmc3-usdreader.patch"


# TODO: remove lines below, that copies the dtb used in AAEON Ubuntu image
SRC_URI_append_jetson-xavier-nx-devkit-emmc = "file://AAEON_tegra194-p3668-all-p3509-0000.dtb"

do_install_append_jetson-xavier-nx-devkit-emmc() {
    cp ${WORKDIR}/AAEON_tegra194-p3668-all-p3509-0000.dtb ${D}/${KERNEL_IMAGEDEST}/tegra194-p3668-all-p3509-0000.dtb
}

