DESCRIPTION = "Image with Matchbox destop manager, based on X11. \
The image contains terminal, editor, and file manager."

IMAGE_FEATURES += "splash package-management x11-base ssh-server-openssh hwcodecs"

IMAGE_INSTALL_append = " packagegroup-core-x11-matchbox"
IMAGE_INSTALL_append = " mesa-demos"

LICENSE = "MIT"

inherit core-image

TOOLCHAIN_HOST_TASK_append = " nativesdk-intltool nativesdk-glib-2.0"
TOOLCHAIN_HOST_TASK_remove_task-populate-sdk-ext = " nativesdk-intltool nativesdk-glib-2.0"

