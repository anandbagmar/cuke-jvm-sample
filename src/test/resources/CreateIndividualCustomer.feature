Feature: Weather check using WebService

  @json
  Scenario Outline: Search for specific content related posts
    Given I create a new Individual Customer
      | entity_type  | data_section_to_use | randomize |
      | contact_info | individual          | false     |
      | addresses    | bne_res_3           | true      |

  Examples:
    | country |
    | India   |

