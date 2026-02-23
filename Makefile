JAVAC = javac
JAVA  = java
SRC   = src
BUILD = build
MAIN  = Main

compile:
	mkdir -p $(BUILD)
	$(JAVAC) -d $(BUILD) -sourcepath $(SRC) $(SRC)/entity/*.java $(SRC)/infrastructure/*.java $(SRC)/usecase/*.java $(SRC)/$(MAIN).java

run: compile
	$(JAVA) -cp $(BUILD) $(MAIN)

clean:
	rm -rf $(BUILD)