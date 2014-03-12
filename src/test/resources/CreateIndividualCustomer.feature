Feature: Test Data Management example

  @json
  Scenario: Use test data from json example
    Given I create a new Individual Customer
      | entity_type  | data_section_to_use |
      | contact_info | individual_1        |
      | addresses    | bne_res_3           |

  @json
  Scenario Outline: Use test data across steps
    Given I create a new Individual Customer
      | entity_type  | data_section_to_use   | randomize   |
      | contact_info | individual_1          | <randomize> |
      | addresses    | <data_section_to_use> | <randomize> |
    When I load test data implicitly

  Examples:
    | data_section_to_use | randomize |
    | bne_res_2           | true      |
    | bne_res_3           | false     |
