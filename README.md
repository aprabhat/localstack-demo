# localstack-demo

#Steps

#Step-1: Start Localstack server using below command

`docker run -it -p 4567-4597:4567-4597 -p 8080:8080 --env LAMBDA_EXECUTOR=docker --env DOCKER_HOST=unix:///var/run/docker.sock -v /var/run/docker.sock:/var/run/docker.sock localstack/localstack`

#Step-2: Open a new terminal and create s3 bucket

`aws s3 mb s3://personbucket --endpoint-url http://localhost:4572`

#Step-3: Create dynamo DB table

`aws dynamodb create-table --table-name PersonDetails --attribute-definitions AttributeName=Id,AttributeType=N --key-schema AttributeName=Id,KeyType=HASH --provisioned-throughput ReadCapacityUnits=5,WriteCapacityUnits=5 --endpoint-url http://localhost:4569`

#Step-4: Create AWS lambda function using the Uber jar

`aws lambda create-function --endpoint-url=http://localhost:4574 --function-name samplelambda --runtime java8 --handler lambda.S3EventHandler --zip-file fileb://lambdademo-1.0.0.jar --role arn:aws:iam::123456:role/irrelevant --environment Variables="{PROFILE=LOCAL,AWS_REGION=us-east-1}"`

#Step-5: Create put bucket notification

`aws s3api put-bucket-notification-configuration --bucket personbucket --notification-configuration file://notification.json --endpoint-url http://localhost:4572`

#Step-6: Scan the dynamo db table

`aws dynamodb scan --table-name PersonDetails --endpoint-url http://localhost:4569`

#Step-7: Copy the sample json in s3 bucket

`aws s3 cp sample.json s3://personbucket/sample.json --endpoint-url http://localhost:4572`

#Step-8: Scan the dynamo db table again

`aws lambda delete-function --function-name samplelambda --endpoint-url=http://localhost:4574`

##Note: Make sure the entry of above created bucket
127.0.0.1 {{bucketname}}.localhost
is placed in hosts file present in below location,
C:\Windows\System32\drivers\etc\ for Windows
/etc/hosts for Linux
