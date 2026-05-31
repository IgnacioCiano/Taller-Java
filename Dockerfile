FROM sapmachine:25

WORKDIR /app

COPY . .

RUN apt-get update && apt-get install -y maven

RUN mvn compile

CMD ["mvn", "exec:java", "-Dexec.mainClass=com.example.tallerjava.Ejercicio4"]