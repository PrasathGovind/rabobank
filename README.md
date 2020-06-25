# rabobank-pocs

This is a sample REST API to perform payments-initiation for Rabobank's Third Partys.
Currently it is designed to run in port 8080 so that GCP's health monitoring can work properly.

API Signature :

POST : /v1.0.0/initiate-payment

Port : 
8080

Headers :
X-Request-Id
Content-Type
Signature-Certificate
Siganature

Body :
{"debtorIBAN":"NL02RABO7134384551",
 "creditorIBAN":"NL94ABNA1008270121",
 "amount":"1.00",
 "currency":"USD",
 "endToEndId":"jsadg-232jwaed-213afsd-232"}
