terraform {
	required_version = ">= 0.13.1"
	required_providers {
		aws = {
			source = "hashicorp/aws"
			version = ">= 3.28.0"
		}
	}	
}
provider "aws" {
	region = "us-east-2"
}

data "aws_vpc" "default" {
  default=true
}
data "aws_ami" "linux"{
    most_recent = true
    owners = ["137112412989" ]
    filter { 
        name = "name"
        values = ["amzn2-ami-kernel-5.10-hvm-*"]
        }
    filter { 
        name = "root-device-type"
        values = ["ebs"]
        }
    filter { 
        name = "virtualization-type"
        values = ["hvm"]
        }
}
resource "aws_instance" "awsInstance" {
    ami = data.aws_ami.linux.id
    instance_type = "t2.micro"
    key_name = "KeyInstanceMain"
    tags = {
        Name = "LinuxInstanceGrupo7"
    }
}
resource "aws_s3_bucket" "s3grupo"{
    bucket = "booking-grupo7"
    acl = "public-read"
    tags = {
        Name = "tagbucketgrupo7"
    }
}
resource "aws_db_instance" "awsdbinstancegrupo7" {
    allocated_storage    = 10
    engine               = "mysql"
    engine_version       = "8.0.23"
    instance_class       = "db.t2.micro"
    skip_final_snapshot  = true
    name = "awsdbinstancegrupo7"
    username = "basededatos"
    password = "12345678"
}
