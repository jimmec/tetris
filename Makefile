FLAGS=-d bin
JAVAC=javac
sources = $(shell find src -type f -name '*.java')
classes = $(patsubst src/%.java, bin/%.class, $(sources))

all: tetris.jar
tetris.jar: $(classes) 
	echo $(classes)
	jar cvfe tetris.jar Tetris -C bin .

%.class: 
	mkdir bin
	$(JAVAC) $(FLAGS) $(sources)

run: tetris.jar
	java -jar tetris.jar

clean:
	rm -rf bin
	rm -f tetris.jar
cleanlog:
	rm -f *.log*
