@para
Feature:
Parallel Testing

Scenario: Google

Given i launch "google"
And i search something on "google"


Scenario: Bing
Given i launch "bing"
And i search something on "bing"
