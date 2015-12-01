#!/usr/bin/python

# maakt gebruik van mysql connector deze kan je vinden op
#	https://dev.mysql.com/downloads/connector/python/

import mysql.connector as _mysql
import sys

try:
	cnx = _mysql.MySQLConnection(user='royco', password='roycoroyco', host='db4free.net', database='project_jee_2015')

except _mysql.Error as err:
	if err.errno == errorcode.ER_ACCESS_DENIED_ERROR:
		print("Geen toegang")
	elif err.errno == errorcode.ER_BAD_DB_ERROR:
		printf("Database does not exist")
	else:
		print(err)
	exit(1)

print("Connectie gelegd - er wordt vervolgens voor de gegevens gevraagd:")
pvoornaam = input("pvoornaam: ")
pachternaam = input("pachternaam: ")
username = input("username: ")
userpass = input("userpass: ")
fnr = int(input("filiaalnr: "))

cursor =  cnx.cursor()

cursor.execute("INSERT INTO `Persoon` (`pnr`, `pvoornaam`, `pachternaam`, `username`, `userpass`, `usergroup`) VALUES (NULL, '%s', '%s', '%s', '%s', 'werknemer')" % (pvoornaam, pachternaam, username, userpass))
cnx.commit()

cursor.execute("SELECT pnr FROM Persoon WHERE username='%s';" % username)

pnr = int(cursor.fetchone()[0])

cursor.execute("INSERT INTO `Werknemer` (`wnr`, `pnr`, `fnr`) VALUES (NULL, '%d', '%d');" % (pnr, fnr))
cnx.commit()
cursor.close()

cnx.close()
