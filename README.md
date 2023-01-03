# User Service


## Running locally

### To run user-service locally you will need to run a psql server locally

MacOS

    brew install postgresql
    brew services start postgresql

Ubuntu 

    sudo apt install postgresql
    sudo systemctl start postgresql.service



### To test the email sending of this application you can run a mail server in a docker image running the following command

    docker run -p 1080:1080 -p 1025:1025 maildev/maildev
