Feature: Cargue de los archivos Rips, y procesamiento de los mismos
  Yo como usuario requiero cargar, procesar y gestionar archivos Rips de las diferentes modalidades
  Capita, Evento y PGP

  Background: 
    Given me autentico con audliqreg y contraseña conexia2017

  @CargarRipsDeEvento
  Scenario: Carga Archivos rips de modalidad Evento
    When Ingreso al modulo de Cuenta, a Validar RIPS
    And Diligencio el formulario de Cargue y Vaidación de Rips
      | ips                                                      | sede                                                    | mesPrestacion | anhoPrestacion | nroCuenta | valorCuenta | regimen    | controto  | modalidad | responsableDePago | regional           |
      | FEDERACION GREMIAL DE TRABAJADORES DE LA SALUD  FEDSALUD | FEDERACION GREMIAL DE TRABAJADORES DE LA SALUD FEDSALUD | Febrero       |           2019 |     19597 |      433500 | SUBSIDIADO | 0427-2018 | EVENTO    | EPS SAVIA SALUD   | Regional Antioquia |
    And Es multiusuario: Si
    And Adjunto el o los archivos de Rips y los Cargo
      | archivos                          |
      | C:/CT000138/CT000138/AC000138.txt |
      | C:/CT000138/CT000138/AD000138.txt |
      | C:/CT000138/CT000138/AF000138.txt |
      | C:/CT000138/CT000138/CT000138.txt |
      | C:/CT000138/CT000138/US000138.txt |
    And Consulto el estado de la cuenta gestionada para la ips
      | ips                                                      | nroCuenta |
      | FEDERACION GREMIAL DE TRABAJADORES DE LA SALUD  FEDSALUD |     19597 |
    Then La cuenta se encuentra en estado
      | cuenta | estadoCuenta         |
      |  19597 | PENDIENTE VALIDACIÓN |

  @GestionarCuentaEnviarHomologar
  Scenario: Envio la cuenta validada a Homologacion
    When Ingreso al modulo de Cuenta, a Gestión de cuentas validadas
    And Consulto el estado de la cuenta gestionada para la ips
      | ips                                                      | nroCuenta |
      | FEDERACION GREMIAL DE TRABAJADORES DE LA SALUD  FEDSALUD |     19597 |
    And Gestiono la encuenta, Enviar a homologar
    And Consulto el estado de la cuenta gestionada para la ips
      | ips                                                      | nroCuenta |
      | FEDERACION GREMIAL DE TRABAJADORES DE LA SALUD  FEDSALUD |     19597 |
    Then La cuenta se encuentra en estado
      | cuenta | estadoCuenta           |
      |  19597 | PENDIENTE HOMOLOGACION |

  @GestionarCuentaFinalizarHomologacion
  Scenario: Envio la cuenta validada a Homologacion
    When Ingreso al modulo de Cuenta, a Gestión de cuentas validadas
    And Consulto el estado de la cuenta gestionada para la ips
      | ips                                                      | nroCuenta |
      | FEDERACION GREMIAL DE TRABAJADORES DE LA SALUD  FEDSALUD |     19597 |
    And Gestiono la encuenta, Finalizar homologación
    And Consulto el estado de la cuenta gestionada para la ips
      | ips                                                      | nroCuenta |
      | FEDERACION GREMIAL DE TRABAJADORES DE LA SALUD  FEDSALUD |     19597 |
    Then La cuenta se encuentra en estado
      | cuenta | estadoCuenta           |
      |  19597 | HOMOLOGACION TERMINADA |

  @GestionarCuentaEnviarAVerificarEPS
  Scenario: Envio la cuenta validada a Homologacion
    When Ingreso al modulo de Cuenta, a Gestión de cuentas validadas
    And Consulto el estado de la cuenta gestionada para la ips
      | ips                                                      | nroCuenta |
      | FEDERACION GREMIAL DE TRABAJADORES DE LA SALUD  FEDSALUD |     19597 |
    And Gestiono la encuenta, Enviar a Verificación EPS
    And Consulto el estado de la cuenta gestionada para la ips
      | ips                                                      | nroCuenta |
      | FEDERACION GREMIAL DE TRABAJADORES DE LA SALUD  FEDSALUD |     19597 |
    Then La cuenta se encuentra en estado
      | cuenta | estadoCuenta |
      |  19597 | ENVIADO      |

  @RevisarFacturasCuentaEps
  Scenario: Reviso como EPS las facturas de la cuenta
    When Ingreso al modulo de Liquidación de Prestaciones, a Gestión de cuentas - EPS
    And Consulto como Eps el estado de la cuenta
      | nroCuenta |
      |     19597 |
    And Gestiono la encuenta como Eps, Revisión y Devolución de cuentas
    And Marco la cuenta con todas las Facturas como Revisado
    And Consulto como Eps el estado de la cuenta
      | nroCuenta |
      |     19597 |
    Then La cuenta se encuentra por la Eps en estado
      | cuenta | estadoCuenta |
      |  19597 | REVISADO     |

  @RegostroCuentaEps
  Scenario: Registro como EPS las cuenta
    When Ingreso al modulo de Liquidación de Prestaciones, a Gestión de cuentas - EPS
    And Consulto como Eps el estado de la cuenta
      | nroCuenta |
      |     19597 |
    And Gestiono la encuenta como Eps, Registrar Cuenta EPS
    And Radico la cuenta con la Eps
      | regional           | responsableDePago | Observaciones |
      | Regional Antioquia | EPS SAVIA SALUD   | Observaciones |
    And Consulto como Eps el estado de la cuenta
      | nroCuenta |
      |     19597 |
    Then La cuenta se encuentra por la Eps en estado
      | cuenta | estadoCuenta      |
      |  19597 | PROCESANDO CUENTA |
