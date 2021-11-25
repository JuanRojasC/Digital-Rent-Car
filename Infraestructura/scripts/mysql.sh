#! /bin/sh
set -e

sudo apt-get update
sudo apt-get install gnupg
sudo wget https://dev.mysql.com/get/mysql-apt-config_0.8.20-1_all.deb
sudo dpkg -i mysql-apt-config_0.8.20-1_all.deb
sudo apt update
sudo apt-get install mysql-server mysql-client libmysqlclient-dev