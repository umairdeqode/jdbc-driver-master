# Skyflow JDBC Driver

This is a generic JDBC driver which acts as a wrapper over the data API of Skyflow. (.jar) file of this driver can be used in any SQL client (like DBeaver, Datagrip etc) to fetch the data from the Skyflow Data API directly. The JWT required for accessing the data via API is being generated within the driver using credential.json file (given by the user) and Skyflow dependency.


### Credentials.json file
This file can be downloaded from the Skyflow studio. Steps to download credentials.json file:
1) In Studio, click Settings in the upper navigation.
2) In the side navigation, click Vault, then choose the vault you want to create a service account for from the dropdown menu.
3) Under IAM, click Service Accounts, then click New Service Account.
4) For Name, enter a value. For example, "Authenticate".
5) For Roles, select Vault Editor.
6) Click Create.
7) Your browser downloads a credentials.json file. Store this file in a secure location.

### Driver Properties
Credentials.json file has the user credentials (like clientID, clientName, tokenURI etc.) using which the driver generates the jwt with the help of Skyflow dependency for hitting the skyflow data api. The absolute path to the directory of this file has to be given in driver properties with the key 'filepath' at the time of connecting to this driver.



### JDBC Connection URL
At the time of connnecting to this driver, the user will have to provide a jdbc connection URL.

The URL will be in this format:

jdbc:skyflow:<URL to skyflow Data API>:<Vault ID>

Example: jdbc:skyflow:https://sb.area51.vault.skyflowapis.dev/:u4882705de68469d92b5aa1d9ada9740

