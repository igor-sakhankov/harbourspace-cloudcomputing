#resource "aws_s3_bucket" "harbour-bucket-terraform" {
#  bucket        = "harbour-bucket-terraform-lecture"
#  force_destroy = true
#
#  tags = {
#    Name        = "harbour-bucket-terraform-lecture"
#    Environment = "lecture"
#  }
#}
#
#provider "aws" {
#  region = "us-east-1"
#  shared_config_files = [
#    "~/.aws/credentials"
#  ]
#}
#
#terraform {
#  required_providers {
#    aws = {
#      source  = "hashicorp/aws"
#      version = "~> 4.0"
#    }
#  }
#}