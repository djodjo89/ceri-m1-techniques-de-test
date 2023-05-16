tests:
	mvn test
rapport:
	mvn site;mvn post-site
format:
	mvn spotless:apply
