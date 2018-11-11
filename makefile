JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(FLAGS) $*.java

CLASSES = \
		Main.java
		Autour.java
		Generateur.java
		ControleurTextField.java
		ControleurBoutonMenu.java
		ControleurFenetre.java
		Cases.java
		Fenetre.java
		Grille.java
		Clics.java
		ControleurSouris.java

default: classes

classes: $(CLASSES:.java=.class)

clean: $(RM) *.class
