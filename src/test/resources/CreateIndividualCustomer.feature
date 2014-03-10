Feature: Weather check using WebService

  @json
  Scenario Outline: Search for specific content related posts
    Given I create a new Individual Customer
      | entity_type  | data_section_to_use |
      | contact_info | individual_1        |
      | addresses    | bne_res_3           |

  Examples:
    | country |
    | India   |

