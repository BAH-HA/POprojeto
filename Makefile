JAVADIR=
JARNAME=po-uilib

all:
	(cd src; javac -encoding UTF-8 `find . -name \*.java`)
	(cd src; jar cf ../$(JARNAME).jar `find . -name \*.class -o -name \*.java`)

clean:
	$(RM) $(JARNAME).jar `find . -name \*.class`

run:
	java -cp po-uilib.jar:. prr.app.App
