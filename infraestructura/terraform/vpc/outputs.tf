#outputs.tf
output "subnet_id" {
value = aws_subnet.aws_subnet_public.id
}

output "subnet_private_id" {
value = aws_subnet.aws_subnet_private.id
}
