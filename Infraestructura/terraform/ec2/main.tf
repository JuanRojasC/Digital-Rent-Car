data "aws_ami" "debian" {
most_recent = true
owners = ["831294158317"]

filter {
name = "name"
values = ["debian-10-amd64-20210329-591*"]
}
}

resource "aws_key_pair" "pk" {
  key_name   = "myKey"
  public_key = "MIIEowIBAAKCAQEA314ueM3Zke2UJ4eDzBT2jvyzVzhuJ/ktHjd0zZk1SZEqcZ1KrBj6sY3pr6j3TlT+TGsjddEECKaPZyXLe3Y2EV2gX6WlrHAbvTxgJ26jNexoTPWGKt34dfPbmNcFrPuG47qAIst9re6x9heuw9sEEz92iZ+u8B/5eECwndcd581sJmDxwzAVo5DB1xyC1yfyCCIgraUog5n+lHgNTE9vhsXhtYZxNo59gTWMnnHORWVmqqW9n+L1CZMEDmgD413/dJ7YZ9ylYVKvxBZJiZsW6RiZ+RqDwSB/M31TdK6yNr6vyTEUMAg5wP1RZzZTmvbqHt6Hz4ngZGNXRVeoz4q+IQIDAQABAoIBAQCXC1wHisPOf0aJOIUyUxareExZ9anf1ArjfQK6KRk0pzp5W7DsEXQs7tcQVwTs7mKMEIMJH49HvkIIsTEZSsWjFpnlM+GFasYHQDWRVKp/Q18Ac6MHh9SFBqL/hp+q6ue7RRly7gINxPSIgllGzerCjU6+H8IvVJ/g5nXINnhdj3Kvml6zqXEt8EY0D1Vs8QRkQuw+8eJAurzBwpm3/SL5QeSMPTB63O11Gx6Lgo2ZmHV08so58r9jbNdYd7YbzkO3TWDNAs5EbGdSwar8QCVYU5Vo6E6aG3DOoZD+8/yZAqPKA8Ik9hmrJWr2FTGFukQpCTHVCDCeHFsp6GrsWybxAoGBAP9o9Wa3QaOLUCZJFJzjcfoCh6fJ0Oe+TcL2rlFnrJ0GYDEHkSDxGr35QmAf65knVbhduYx7iqd2SyI4rrt8g84D70QPYXmQZwKmEknhsgZCWdOVWfGsQdeQeigFlFCujuDjsA8LLzP/IqyFNcPdN4bliABn+0y1wrfywcXAkTXFAoGBAN/iRjUbxRqN8n8BTgvJcmj1OCEKbWfqOL1sqAHyqBW+h92NFdlKhYhIpxqv7j4mr3FoSOehhHf8YNaXhXmqxtsfnHnM0VDBgrkqjnzMw54vnZQdBo55fFaUYNDR3u/cWw743qDew9qAO1fX+p0pHioRo6/v9vA1m8qjuEIrwkitAoGAWaSjDQwg05/f37AitfX2WQNuTWu+ELhwXo9qG1RB91L3i/3V6DP3aNoFe+t4K2bs5SqwJyhtP916/WXbnh5TvIkQ/1hOo/YU0Y8sOBYo/51mHab7zKDi8x/YYBelOLQrna8MahtI0/0mVFrkxfvss0H4e/wC7aeV0i436Ipv7OkCgYBA7IBJlGUDP1isJfe5CVEJSNtfEYQKl2ye2eyarAC8VYVW5TwJyEeS7uauoYgoM9W6wHAr47XjiaeXc1c8oh6Kms8orxGgJo2/Hq01Wbf8nnhG5GfrVyWMgfjVdZb93dv2Kot9ATywl3EeFz7Q5oSd1IGwWpk0rYchK3sajVAI/QKBgHXgsA01xTTCcZ+acHpNNlymGzg73xvitKr/49EF+XV6lmBnXMdW56XmfPMSPgowKa4z40IbNQuGYvYK+bE8E7EchBpHn8UhH0TPqFbnO84IUmyiCcPCKqBogibWex10gBTDUz2nslcAOZfrQvqL/r11DxqBgCtYqRCpYmgzNKQC"
}

resource "aws_instance" "frontend" {
ami = data.aws_ami.debian.id
instance_type = "t2.micro"
subnet_id = aws_subnet.subnet.id

tags = {
 Name = "Frontend"
}
}

resource "aws_instance" "backend" {
ami           = data.aws_ami.debian.id
instance_type = "t3a.xlarge"
subnet_id = aws_subnet.subnet.id

tags = {
 Name = "Backend"
}
}