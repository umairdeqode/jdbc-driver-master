# Skyflow JDBC Driver

This is a generic JDBC driver which acts as a wrapper over the data API of Skyflow. (.jar) file of this driver can be used in any SQL client (like DBeaver, Datagrip etc) to fetch the data from the Skyflow Data API directly. The JWT required for accessing the data via API is being generated within the driver using credential.json file (given by the user) and Skyflow dependency.



## API End Point
- https://manage.skyflowapis.dev/v1/vaults/<vault id>
- payload example: {"query": "select * from template;" }


### Credentials.json file
This file can be downloaded from the Skyflow studio. It has the user credentials (like clientID, clientName, tokenURI etc.) using which the driver generates the jwt with the help of Skyflow dependency for hitting the skyflow data api. The absolute path to the directory of this file has to be given in driver properties with the key 'filepath' at the time of connecting to this driver.

### JDBC Connection URL
At the time of connnecting to this driver, the user will have to provide a jdbc Connection URL.

The URL will be in this format:

jdbc:skyflow:<URL to skyflow Data API>:<Vault ID>

Example: jdbc:skyflow:https://sb.area51.vault.skyflowapis.dev/:u4882705de68469d92b5aa1d9ada9740

