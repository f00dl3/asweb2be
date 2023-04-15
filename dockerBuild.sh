sudo docker build -t asweb2be .
sudo docker run --restart=always -d -p 8082:8082 --net=host -P asweb2be &
