compose-deploy:
	docker-compose -f ci/docker-compose.yml up --build -d

compose-down:
	docker-compose -f ci/docker-compose.yml down

docker-build-image:
	docker build --rm -f ci/Dockerfile -t ankeshkprasad/gRPCInAction:v1.0.0-SNAPSHOT1 .

build-and-deploy-docker: docker-build-image compose-deploy