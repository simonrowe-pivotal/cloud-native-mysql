# cloud-native-mysql
Example app that uses spring profiles to create a common artifact that will consume google cloud sql for mysql when running on GCP, and using an RDS datasource when running on AWS.

We have two spring proflies:

* aws 
* gcp

There are also two manifest files as auto reconfiguration needs to be disabled when utilising google cloud sql bound services.
