ARG NODE_VERSION=14.20.0
# Pin Alpine version to make sure that it's compatible with gradle image
# Check exact Alpine version (like 3.16.2): docker run -it node:14.20.0-alpine3.16 /bin/sh -c "cat /etc/os-release"
ARG NODE_IMAGE_ALPINE_VERSION=3.16
# Give sha256 to make sure that it's compatible with node image (Alpine version isn't in any tag)
# Check exact Alpine version (like 3.16.2): docker run -it gradle:6-jdk11-alpine /bin/sh -c "cat /etc/os-release"
# Show sha256 of images: docker images --digests
ARG GRADLE_IMAGE_SHA256=a0a841a918a83987218a84b48865c1e52da1b2038095ea321eaac89dfc2ad60d

FROM node:$NODE_VERSION-alpine$NODE_IMAGE_ALPINE_VERSION AS node

FROM gradle:6-jdk11-alpine@sha256:$GRADLE_IMAGE_SHA256

# Copy node, its dependencies from the node image (other things are the same if same exact Alpine version)
COPY --from=node /usr/lib /usr/lib
COPY --from=node /usr/local/share /usr/local/share
COPY --from=node /usr/local/lib /usr/local/lib
COPY --from=node /usr/local/include /usr/local/include
COPY --from=node /usr/local/bin /usr/local/bin
