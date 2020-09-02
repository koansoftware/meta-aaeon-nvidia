SUMMARY = "Matchbox window manager extra themes"
HOMEPAGE = "http://www.matchbox-project.org/"
BUGTRACKER = "http://bugzilla.yoctoproject.org/"

LICENSE = "CC-BY-SA-3.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/CC-BY-SA-3.0;md5=3248afbd148270ac7337a6f3e2558be5"

DEPENDS = "matchbox-wm"
SECTION = "x11/wm"

inherit autotools pkgconfig features_check

FILES_${PN} += "${datadir}/themes ${datadir}/icons"

# The matchbox-wm requires x11 in DISTRO_FEATURES
REQUIRED_DISTRO_FEATURES = "x11"

SRCREV = "${AUTOREV}"
SRC_URI = "git://git.yoctoproject.org/matchbox-themes-extra \
	   file://fix-makefiles.patch"

S = "${WORKDIR}/git"
