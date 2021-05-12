provider "aws" {
    region = "us-east-2"
    access_key = "AKIATATPGVRLRZQ5YDEO"
    secret_key = "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"
}

resource "aws_subnet" "subnet-1" {
  vpc_id = aws_vpc.first-vpc.id
  cidr_block = "10.0.1.0/24"

  tags = {
    Name = "prod-subnet"
  }
}

resource "aws_vpc" "first-vpc" {
  cidr_block = "10.0.0.0/16"
  tags = {
    Name = "production"
  }
}

# resource "aws_instance" "my-first-server" {
#     ami = "ami-00399ec92321828f5"
#     instance_type = "t2.micro"
# }