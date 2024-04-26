database

docker run --name postgres -d -p 5432:5432 -e POSTGRES_PASSWORD=@pass0rd@@@ -e POSTGRES_USER=dimitris -e POSTGRES_DB=eshop postgres:alpine

swagger

http://localhost:5001/swagger-ui/index.html