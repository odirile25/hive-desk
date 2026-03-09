.PHONY: build test run package docker-build docker-run clean

build:
	mvn clean compile

test:
	mvn test

run:
	mvn compile exec:java -Dexec.mainClass=agurchu.hivedesk.HiveDesk

package:
	mvn clean package

docker-build:
	docker build -t hivedesk:latest .

docker-run:
	docker run --rm -it hivedesk:latest

clean:
	mvn clean
	rm -rf target/