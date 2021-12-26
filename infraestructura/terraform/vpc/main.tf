resource "aws_vpc" "vpc" {
  cidr_block       = "10.0.0.0/16"
  instance_tenancy = "default"

  tags = {
    Name = "vpc"
  }
}

resource "aws_subnet" "aws_subnet_public" {
  vpc_id     = "vpc-7a117c07"
  map_public_ip_on_launch = true
  cidr_block = "10.0.1.0/24"
  tags = {
    Name = "subnet"
  }

}
resource "aws_subnet" "aws_subnet_private" {
  vpc_id     = "vpc-7a117c07"
  map_public_ip_on_launch = true
  cidr_block = "10.0.2.0/24"
  tags = {
    Name = "subnet"
  }

}

resource "aws_security_group" "sg" {
  name        = "SecurityGroupDH"
  description = "Grupo de seguridad"
  vpc_id      = aws_default_vpc.default.id

  ingress = [
    {
      description      = "MySQL"
      from_port        = 3306
      to_port          = 3306
      protocol         = "tcp"
      cidr_blocks      = ["190.221.173.200/32"]
      ipv6_cidr_blocks = ["::/0"]
      prefix_list_ids = []
      security_groups = []
      self = true
    },
    {
      description      = "SSH"
      from_port        = 22 // 21 >>> 22
      to_port          = 22 // 21 >>> 22
      protocol         = "tcp"
      cidr_blocks      = ["0.0.0.0/0"]
      ipv6_cidr_blocks = ["::/0"]
      prefix_list_ids = []
      security_groups = []
      self = true
    }
  ]

tags = {
    Name = "Security_Group_DH"
  }
}