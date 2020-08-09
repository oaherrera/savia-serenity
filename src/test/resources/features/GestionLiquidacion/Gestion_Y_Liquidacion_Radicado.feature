Feature: Ralizar la gestion del radicado hasta poder llegar
  a la liquidación de la cuenta, cargada en rips.

  @LegalizarCuenta
  Scenario: Legalizar la cuenta con la Eps
    Given me autentico con audliqreg y contraseña conexia2017
    When Ingreso al modulo de Liquidación de Prestaciones, a Gestión de cuentas - EPS
    And Consulto como Eps el estado de la cuenta
      | nroCuenta |
      |       022 |
    And Gestiono la encuenta como Eps, Legalizar Cuenta
    And Consulto como Eps el estado de la cuenta
      | nroCuenta |
      |       022 |
    Then La cuenta se encuentra por la Eps en estado
      | cuenta | estadoCuenta |
      |    022 | RADICADO     |

  @ListaDeTrabajoMarcarCuentasRevisadas
  Scenario: Marco como revisadas las facturas en Listas de trabajo
    Given me autentico con audliqreg y contraseña conexia2017
    When Ingreso al modulo de Liquidación de Prestaciones, a Lista de trabajo radicados
    And Consulto radicado en listas de trabajo
      | filtrarPor           | valorBusqueda |
      | Nro. Cuenta de Cobro |           022 |
      | Radicado             |          1431 |
    And Realizo la accion Ver Detalle en listas de trabajo
    And Diligenciar Opciones de Factura Informacion complementaria
      | codDiagnostico | aplicaPBS | centroDeCosto    | altoCosto | aplicaNOPBS |
      | A040           | Si        | MEDICINA GENERAL | No        | No          |
    And Marco todas las facturas como revisadas
    And Consulto radicado en listas de trabajo
      | filtrarPor           | valorBusqueda |
      | Nro. Cuenta de Cobro |           022 |
      | Radicado             |          1431 |
    Then Radicado en estado Revisada en listas de trabajo radicado

  @AsignoAusitoryLiquidador
  Scenario: Asigno al auditor y al liquedador en la bandeja de Radicado
    Given me autentico con audliqreg y contraseña conexia2017
    When Ingreso al modulo de Liquidación de Prestaciones, a Bandeja radicados
    And Consulto radicado en listas de trabajo
      | filtrarPor           | valorBusqueda |
      | Nro. Cuenta de Cobro |           022 |
      | Radicado             |          1431 |
    And Realizo la accion Asignar en listas de trabajo
    And Asigno a CRISTIAN ARLEY OSPINA SALAZAR, de la Regional: Regional Antioquia, con el cargo: Auditor médico
    And Asigno a VIVIANA ANDREA MIRANDA OCAMPO, de la Regional: Regional Antioquia, con el cargo: Jefe liquidación
    Then Puedo ver a CRISTIAN ARLEY OSPINA SALAZAR, en asignación actual
    And Puedo ver a VIVIANA ANDREA MIRANDA OCAMPO, en asignación actual

  @FinalizarAuditoriaAuditorMedico
  Scenario: Finalizar la auditoria con el auditor Medico
    Given me autentico con cristian.ospina@saviasaludeps.com y contraseña 1037324227
    When Ingreso al modulo de Liquidación de Prestaciones, a Lista de trabajo radicados
    And Consulto radicado en listas de trabajo
      | filtrarPor           | valorBusqueda |
      | Nro. Cuenta de Cobro |           022 |
      | Radicado             |          1431 |
    And Realizo la accion Finalizar Auditoria en listas de trabajo
    And Ingreso al modulo deplegado de Liquidación de Prestaciones, a Bandeja radicados
    And Consulto radicado en listas de trabajo
      | filtrarPor           | valorBusqueda |
      | Nro. Cuenta de Cobro |           022 |
      | Radicado             |          1431 |
    Then Radicado en estado Pendiente liquidación en listas de trabajo radicado

  @CierreDeCuentaLiquidador
  Scenario: Cierra la cuenta con el usuario liquidador
    Given me autentico con viviana.miranda@saviasaludeps.com y contraseña 1017142017
    When Ingreso al modulo de Liquidación de Prestaciones, a Bandeja radicados
    And Consulto radicado en listas de trabajo
      | filtrarPor           | valorBusqueda |
      | Nro. Cuenta de Cobro |           022 |
      | Radicado             |          1431 |
    And Realizo la accion Ver Detalle en listas de trabajo
    And Cierro la cuenta y confirmo cierre de cuenta
    And Ingreso al modulo deplegado de Liquidación de Prestaciones, a Bandeja radicados
    And Consulto radicado en listas de trabajo
      | filtrarPor           | valorBusqueda |
      | Nro. Cuenta de Cobro |           022 |
      | Radicado             |          1431 |
    Then Radicado en estado Liquidado en listas de trabajo radicado
