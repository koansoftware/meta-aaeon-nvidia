# BSP layer for AAEON BOXER based on NVIDIA platforms

![aaeon.com](https://www.aaeon.com/emgz/client_logo.png)

First release

Boards supported:

![BOXER-8251AI](https://www.aaeon.com/_media/tmb_200511_tgvakc.jpg) ![BOXER-8221AI](https://www.aaeon.com/_media/tmb_200323_6rboad.jpg) 
![BOXER-8250AI](https://www.aaeon.com/_media/tmb_200511_eqn31v.jpg) ![BOXER-8220AI](https://www.aaeon.com/_media/tmb_200323_s2ho8e.jpg)

[AAEON NVIDIA AI Solutions](https://www.aaeon.com/en/c/aaeon-nvidia-ai-solutions)

* Aaeon BOXER-8220AI
* Aaeon BOXER-8221AI
* Aaeon BOXER-8250AI
* Aaeon BOXER-8251AI

This layer depends on:
URI: https://github.com/OE4T/meta-tegra
branch: dunfell
LAYERSERIES_COMPAT: dunfell

# Build instructions

Move into the build directory already setup with the [inital setup step](https://github.com/koansoftware/koan-aaeon-bsp-repo), for example:

```
$ cd ${HOME}/yocto-aaeon-dunfell
```

## First setup

Initialize a build directory and related environment enter in the main Yocto directory and use the `setup-environment` script:

```bash
$ MACHINE=... DISTRO=aaeon source setup-environment MY_BUILDDIR
```

Machines to use are:

* `jetson-nano-qspi-sd` for BOXER-8220AI and BOXER-8221AI
* `jetson-xavier-nx-devkit-emmc` for BOXER-8250AI and BOXER-8251AI

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
$ bitbake core-image-minimal
```
or 

```bash
$ bitbake core-image-minimal-xfce
```

# Flashing instructions

To flash the built image onto the BOXER devices internal storage we need to do the following steps:

* disconnect the power cable on the BOXER board
* connect the USB type-A port of a Micro-USB cable to the build PC
* hold the RECOVERY button on the BOXER and connect the power cable
* continue to hold the RECOVERY button for two seconds, then release it
* start the flash procedure launching `scripts/deploy-aaeon.sh`. For example, for a BOXER-8820AI (Jetson Nano platform), if we built the `core-image-minimal-xfce` image in `build` directory.

Please verify that you are in the build directory before running the following command:
  ```bash
  $ ../sources/meta-aaeon-nvidia/scripts/deploy-aaeon.sh core-image-minimal-xfce jetson-nano-qspi-sd .
  ```
  NB: the script will ask the **sudo** password
* At the end of the flashing procedure, if there are no errors, disconnect and reconnect the power cable. The board will run the image just flashed.

## System Login

Poky linux login is the standard one:

* Username : root
* Password : <no password, press enter>


# Contributing

Please use GitHub (https://github.com/koansoftware/meta-aaeon-nvidia) to submit issues or pull requests, or add to the documentation on the wiki. Contributions are welcome!

------

_(C)2020-2021 Copyright - KOAN sas - <https://koansoftware.com>_
