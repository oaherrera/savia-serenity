Feature: Negociación

  Background: 
    Given me autentico con contratacion y contraseña 1234

  @CreoNegociacion
  Scenario: Deseo crear una negociación
    When Ingreso al modulo de Precontractual, a Negociación
    And Busco al prestador METROSALUD para Ver Negociaciones.
    And Creo la base negociacion
      | modalidad | regimen      | poblacion | complejidad |
      | Evento    | Contributivo |     20000 | Alta        |
    Then Negociación creada correctamente

  @AsignoAreaDeCobertura
  Scenario: Asigno el area de cobertura a la negociación
    When Ingreso al modulo de Precontractual, a Negociación
    And Busco al prestador METROSALUD para Ver Negociaciones.
    And Consulto la negociacion numero: 1384, para Ver negociación
    And Asigno area de cobertura
      | areaCobertura                                     | sede                                                 |
      | Asignar municipios de acuerdo a tabla de general: | UNIDAD HOSPITALARIA DE MANRRIQUE HERMENEGILDO DE FEX |
      | Asignar municipios de acuerdo a tabla de general: | CENTRO DE SALUD TRINIDAD                             |
