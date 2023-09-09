provider "aws" {
  region     = "us-west-2"
  access_key = "AKIA3QEBTAKPOZFZH6JV"
  secret_key = "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"
}

data "aws_vpc" "default" {
  default = true
}

resource "random_string" "report-api-db-password" {
  length  = 32
  upper   = true
  number  = true
  special = false
}

resource "aws_security_group" "report-api-seas" {
  vpc_id      = data.aws_vpc.default.id
  name        = "report-api-seas"
  description = "Allow all inbound for Postgres"
  ingress {
    from_port   = 5432
    to_port     = 5432
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }
}

resource "aws_db_instance" "report-api-seas" {
  identifier             = "report-api-seas-db"
  name                   = "report-api-seas"
  instance_class         = "db.t3.micro"
  allocated_storage      = 5
  engine                 = "postgres"
  engine_version         = "15.2"
  skip_final_snapshot    = true
  publicly_accessible    = true
  vpc_security_group_ids = [aws_security_group.report-api-seas.id]
  username               = "postgres"
  password               = random_string.report-api-db-password.result
}