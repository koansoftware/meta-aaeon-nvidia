#
# Copyright (C) 2020 Koan Software - Bergamo (Italy)
#

SUMMARY = "Matchbox desktop"
PR = "r1"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup features_check
REQUIRED_DISTRO_FEATURES = "x11"

PACKAGES = "${PN} ${PN}-base ${PN}-apps"

RDEPENDS_${PN} = "\
    ${PN}-base \
    ${PN}-apps \
    "

NETWORK_MANAGER ?= "connman-gnome"

SUMMARY_${PN}-base = "Matchbox desktop - base packages"
RDEPENDS_${PN}-base = "\
    matchbox-desktop \
    matchbox-session \
    matchbox-keyboard \
    matchbox-keyboard-applet \
    matchbox-keyboard-im \
    matchbox-config-gtk \
    xcursor-transparent-theme \
    adwaita-icon-theme \
    settings-daemon \
    shutdown-desktop \
    ${NETWORK_MANAGER} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', '', 'udev-extraconf', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'pulseaudio', 'pulseaudio-server pulseaudio-client-conf-sato pulseaudio-misc', '', d)} \
    "

FILEMANAGER ?= "pcmanfm"

WEB ?= ""
#WEB = "epiphany"

SUMMARY_${PN}-apps = "Matchbox desktop - applications"
RDEPENDS_${PN}-apps = "\
    l3afpad \
    matchbox-terminal \
    sato-screenshot \
    ${FILEMANAGER} \
    ${WEB} \
    "

