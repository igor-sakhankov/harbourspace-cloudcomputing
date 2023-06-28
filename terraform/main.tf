resource "aws_s3_bucket" "harbour-bucket-terraform" {
  bucket        = "harbour-bucket-terraform"
  force_destroy = true

  tags = {
    Name        = "harbour-bucket-terraform"
    Environment = "green"
  }
}

resource "aws_s3_bucket_ownership_controls" "harbour-bucket-terraform" {
  bucket = aws_s3_bucket.harbour-bucket-terraform.id
  rule {
    object_ownership = "BucketOwnerPreferred"
  }
}

resource "aws_s3_bucket_public_access_block" "harbour-bucket-terraform" {
  bucket = aws_s3_bucket.harbour-bucket-terraform.id

  block_public_acls       = false
  block_public_policy     = false
  ignore_public_acls      = false
  restrict_public_buckets = false
}

resource "aws_s3_bucket_acl" "example" {
  depends_on = [
    aws_s3_bucket_ownership_controls.harbour-bucket-terraform,
    aws_s3_bucket_public_access_block.harbour-bucket-terraform
  ]

  bucket = aws_s3_bucket.harbour-bucket-terraform.id
  acl    = "public-read"
}

provider "aws" {
  region = "us-east-1"
}

terraform {
  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "~> 4.0"
    }
  }
}

terraform {
  cloud {
    organization = "harbour-space"

    workspaces {
      name = "harbour-space-cloud"
    }
  }
}