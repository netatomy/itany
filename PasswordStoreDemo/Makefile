#
jcc = $(JAVA1.6)

TOP=../../..

include $(TOP)/makefiles/examplerules.mk


.PHONY:  clobber compile jar zip

all: compile jar zip
	
compile: 
	ant -Djarpath=$(JDK1.6PATH)/jre/lib -Dkeystore=$(KEYSTORE) -Dstorepass=$(STOREPASS) -Dalias=$(ALIAS)

clobber:  
	ant clean

jar:   
	ant -Djarpath=$(JDK1.6PATH)/jre/lib -Dkeystore=$(KEYSTORE) -Dstorepass=$(STOREPASS) -Dalias=$(ALIAS) jar

zip:
	ant zip

