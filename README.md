![KoanSoftware.com](http://koansoftware.com/pub/img/koan-header.png)

(C)2020 Copyright - KOAN sas - <https://koansoftware.com>

# BSP layer for AAEON BOXER based on NVIDIA platforms

First release

Boards supported:
* Aaeon BOXER-8220AI
* Aaeon BOXER-8221AI
* Aaeon BOXER-8251AI

This layer depends on:
URI: https://github.com/OE4T/meta-tegra
branch: dunfell
LAYERSERIES_COMPAT: dunfell

# Build instructions

## First setup

To initialize a build directory and related environment enter in the main Yocto directory and use the `setup-environment` script:

```bash
$ MACHINE=... DISTRO=aaeon source setup-environment MY_BUILDDIR
```

Machines to use are:

* `jetson-nano-qspi-sd` for BOXER-8220AI and BOXER-8221AI
* `jetson-xavier-nx-devkit-emmc` for BOXER-8251AI

So, for example, the command for BOXER-8251AI is:

```bash
$ MACHINE=jetson-xavier-nx-devkit-emmc DISTRO=aaeon source setup-environment build
```

## Build image

When not the first setup, to initialize the build environment execute:

```bash
$ source setup-environment build
```

Now you can build one of the included images, e.g.

```bash
$ bitbake core-image-minimal-xfce
```

# Flashing instructions

To flash the built image onto the BOXER devices internal storage we need to do the following steps:

* disconnect the power cable on the BOXER board
* connect a Micro-USB cable to the build PC and to the OS flash port on the BOXER board
* hold the RECOVERY button on the BOXER and connect the power cable
* continue to hold the RECOVERY button for two seconds, then release it
* start the flash procedure launching `scripts/deploy-aaeon.sh`. For example, for a BOXER-8820AI (Jetson Nano platform), if we built the `core-image-minimal-xfce` image in `build` directory, the command is:
  ```bash
  $ scripts/deploy-sd-aaeon.sh core-image-minimal-xfce jetson-nano-qspi-sd ../../build"
  ```
  NB: the script will ask the **sudo** password
* At the end of the flashing procedure, if there are no errors, disconnect and reconnect the power cable. The board will run the image just flashed.

