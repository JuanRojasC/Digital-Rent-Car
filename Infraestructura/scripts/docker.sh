#! /bin/sh
set -e

# DOCKER
sudo apt update
sudo apt-get install gnupg
sudo apt install apt-transport-https ca-certificates curl software-properties-common
curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -
sudo add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/ubuntu focal stable"
sudo apt update
apt-cache policy docker-ce
sudo curl -O https://download.docker.com/linux/debian/dists/buster/pool/stable/amd64/containerd.io_1.4.3-1_amd64.deb
sudo apt install ./containerd.io_1.4.3-1_amd64.deb
sudo apt install docker-ce

# DOCKER-COMPOSE
sudo curl -L "https://github.com/docker/compose/releases/download/1.29.0/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose
sudo chmod +x /usr/local/bin/docker-compose
sudo docker-compose --version