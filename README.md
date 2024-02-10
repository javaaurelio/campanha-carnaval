Criar o mvnw

export JAVA_HOME="/opt/jdk/jdk-11.0.21"

export PATH=$JAVA_HOME/bin:$PATH

/opt/mvn/apache-maven-3.9.6/bin/mvn -N wrapper:wrapper -Dmaven=3.6.2



docker run -d -p 8080:8080 javaaurelio/carnaval:latest



docker build -f dockerfile -t javaaurelio/carnaval:latest .
docker login
docker pull javaaurelio/carnaval:latest



