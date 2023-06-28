resource "aws_instance" "harbour-ec2" {
  ami                    = "ami-0a65d76d95fe9c100"
  instance_type          = "t2.micro"

  vpc_security_group_ids = [aws_security_group.harbour-ec2.id]

  user_data = <<-EOF
              #!/bin/bash
              echo "Hello, World from Harbour" > index.html
              nohup busybox httpd -f -p 8081 &
              EOF

  user_data_replace_on_change = true

  tags = {
    Name = "harbour-ec2"
  }
}

resource "aws_security_group" "harbour-ec2" {
  name = "harbour-ec2"

  ingress {
    from_port   = 8081
    to_port     = 8081
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }
}