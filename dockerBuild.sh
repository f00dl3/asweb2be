sudo docker build -t asweb2be .
sudo docker run -d -p 8082:8082 -P asweb2be
