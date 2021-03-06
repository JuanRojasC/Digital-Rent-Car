#! /bin/sh
set -e

sudo apt-get update

# MYSQL
sudo apt-get install gnupg -y
sudo wget https://dev.mysql.com/get/mysql-apt-config_0.8.20-1_all.deb
sudo dpkg -i mysql-apt-config_0.8.20-1_all.deb
sudo apt update
sudo apt-get install mysql-server mysql-client libmysqlclient-dev -y

# DOCKER
sudo apt update
sudo apt install apt-transport-https ca-certificates curl software-properties-common -y
curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -
sudo add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/ubuntu focal stable"
sudo apt update
apt-cache policy docker-ce
sudo curl -O https://download.docker.com/linux/debian/dists/buster/pool/stable/amd64/containerd.io_1.4.3-1_amd64.deb
sudo apt install ./containerd.io_1.4.3-1_amd64.deb -y
sudo apt install docker-ce -y

# DOCKER-COMPOSE
sudo curl -L "https://github.com/docker/compose/releases/download/1.29.0/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose
sudo chmod +x /usr/local/bin/docker-compose
sudo docker-compose --version

# GIT CREDENTIALS
sudo apt-get install git -y
git config --global credential.helper store