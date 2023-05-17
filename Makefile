build:
	mvn -B -DskipTests clean package
tests:
	mvn test
rapport:
	mvn site;mvn post-site
format:
	mvn spotless:apply
docs:
	mvn javadoc:javadoc;cp target/site/apidocs/* -r docs
