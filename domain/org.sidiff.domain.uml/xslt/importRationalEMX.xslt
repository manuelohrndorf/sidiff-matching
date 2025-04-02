<?xml version="1.0" encoding="ISO-8859-1"?>

<!-- ************************************************************* -->
<!-- XSLT to import an *.emx file from Rational Software Modeler -->
<!-- into an org.sidiff.uml.model instance -->
<!-- ************************************************************* -->
<!-- Not supported yet: -->
<!-- Stereotypes -->
<!-- ************************************************************* -->
<xsl:transform xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
		xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
		xmlns:xmi="http://www.omg.org/XMI"
		xmlns:ecore="http://www.eclipse.org/emf/2002/Ecore" 
		xmlns:notation="http://www.eclipse.org/gmf/runtime/1.0.1/notation" 
		xmlns:uml="http://www.eclipse.org/uml2/2.1.0/UML" 
		xmlns:umlnotation="http://www.ibm.com/xtools/1.5.2/Umlnotation"
		xmlns:Default="http:///schemas/Default/1"
		exclude-result-prefixes="xsl xmi ecore uml notation umlnotation"
		version="1.0">

<xsl:output method="xml" version="1.0" encoding="ISO-8859-1" indent="yes"/>

<!-- Error in script, terminate transformation -->
<xsl:template match="*">
   <xsl:message terminate='yes'>Error: Could not handle <xsl:value-of select="name()"/>, <xsl:value-of select="@*"/></xsl:message>
   <!-- <xsl:comment><xsl:text>Ignored Element: </xsl:text><xsl:value-of select="name()"/></xsl:comment>-->
   <xsl:apply-templates />
</xsl:template>

<!-- Dependencies become sub elements of the dependee -->
<xsl:template match="packagedElement[@xmi:type='uml:Dependency']"/>

<!-- skip XMI root -->
<xsl:template match="xmi:XMI"><xsl:apply-templates /></xsl:template>

<!-- skip documentation nodes -->
<xsl:template match="Default:Documentation"/>


<xsl:key name="importedPrimitiveTypes" match="type[@xmi:type='uml:PrimitiveType' and starts-with(@href,'pathmap://UML_LIBRARIES/')]" use="@href"/>

<xsl:key name="parametersByType" match="ownedParameter[not(@direction)]" use="@type"/>
<xsl:key name="attributesByType" match="ownedAttribute[not(@association)]" use="@type"/>
<xsl:key name="operationsByType" match="ownedParameter[@direction='return']" use="@type"/>

<!-- ************************************************************* -->
<!-- Entry point -->
<!-- ************************************************************* -->
<xsl:template match="uml:Model|uml:Package">
<model.core:UMLModel xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:model.classes="http://www.sidiff.org/org.sidiff.uml.model/classes" xmlns:model.core="http://www.sidiff.org/org.sidiff.uml.model/core" xsi:schemaLocation="http://www.sidiff.org/org.sidiff.uml.model/classes model/UMLModel.ecore#//classes http://www.sidiff.org/org.sidiff.uml.model/core model/UMLModel.ecore#//core" id="{@xmi:id}">
  <xsl:attribute name="name"><xsl:value-of select="@name"/></xsl:attribute>
  <xsl:apply-templates select="./packageImport"/>
  <xsl:apply-templates select="./packagedElement[@xmi:type='uml:Package']"/>
  <xsl:if test="./packagedElement[@xmi:type='uml:Class'] or ./packagedElement[@xmi:type='uml:Enumeration']">
    <packages id="idDefaultPackage" name="" visibility="public">
    <xsl:apply-templates select="./packagedElement[@xmi:type='uml:Class']"/>
    <xsl:apply-templates select="./packagedElement[@xmi:type='uml:Interface']"/>
    <xsl:apply-templates select="./packagedElement[@xmi:type='uml:Enumeration']"/>
    <xsl:apply-templates select="./packagedElement[@xmi:type='uml:Association']"/>
    </packages>
  </xsl:if>
  <!-- <xsl:apply-templates select="//UML:Namespace.ownedElement/UML:Stereotype"/> -->
</model.core:UMLModel>
</xsl:template>

<!-- ************************************************************* -->
<!-- Import of primitive Types (UML and Ecore) --> 
<!-- ************************************************************* -->
<xsl:template match="packageImport">
<xsl:variable name="longtype" select="substring-before(./importedPackage/@href,'#')" />
<xsl:variable name="shorttype" select="substring-after(substring-before(./importedPackage/@href,'.library.uml#'),'pathmap://UML_LIBRARIES/')" />
<packages id="{$shorttype}" name="{$shorttype}" visibility="public">
 <xsl:for-each select="//type[starts-with(@href,$longtype) and generate-id() = generate-id(key('importedPrimitiveTypes', @href)[1]) ]">
 <xsl:variable name="actualtype" select="substring-after(@href,'#')" />
 <xsl:variable name="reference"><xsl:value-of select="$longtype"/><xsl:text>#</xsl:text><xsl:value-of select="$actualtype"/></xsl:variable>
  <primitiveTypes id="{$shorttype}_{$actualtype}" name="{$actualtype}">
  <xsl:attribute name="usedByElements"><xsl:for-each select="key('importedPrimitiveTypes', @href)">
  <xsl:if test="name(..)='ownedAttribute'"><xsl:value-of select="../@xmi:id"/><xsl:text> </xsl:text></xsl:if>
  <xsl:if test="name(..)='ownedParameter' and ../@direction='return'"><xsl:value-of select="../../@xmi:id"/><xsl:text> </xsl:text></xsl:if>
  <xsl:if test="name(..)='ownedParameter' and not(../@direction)"><xsl:value-of select="../../@xmi:id"/><xsl:text>_</xsl:text><xsl:value-of select="../@name"/><xsl:text> </xsl:text></xsl:if>
  </xsl:for-each></xsl:attribute>
  </primitiveTypes>
 </xsl:for-each>
</packages>
</xsl:template>
 
<!-- ************************************************************* -->
<!-- references from instances to imported primitive types -->
<!-- ************************************************************* -->
<xsl:template match="@href">
<xsl:choose>
<xsl:when test="starts-with(substring-before(.,'#'),'pathmap://UML_LIBRARIES/')">
<xsl:variable name="shorttype" select="substring-after(substring-before(.,'.library.uml#'),'pathmap://UML_LIBRARIES/')" />
<xsl:variable name="actualtype" select="substring-after(.,'#')" />
<xsl:value-of select="$shorttype"/><xsl:text>_</xsl:text><xsl:value-of select="$actualtype"/>
</xsl:when>
<xsl:otherwise>
<xsl:value-of select="."/>
<xsl:comment>Warning: reference href <xsl:value-of select="."/> accidentally ignored</xsl:comment>
</xsl:otherwise>
</xsl:choose>
</xsl:template>

<!-- ************************************************************* -->
<!-- Packages -->
<!-- ************************************************************* -->
<xsl:template match="packagedElement[@xmi:type='uml:Package']">
<packages id="{@xmi:id}">
  <xsl:attribute name="name"><xsl:value-of select="@name"/></xsl:attribute>
  <xsl:attribute name="visibility"><xsl:call-template name="visibility"/></xsl:attribute>
  <xsl:apply-templates select="./packagedElement"/>
  <xsl:apply-templates select="./packageImport"/>
</packages>
</xsl:template>

<!-- ************************************************************* -->
<!-- Locally declared primitive types -->
<!-- ************************************************************* -->
<xsl:template match="packagedElement[@xmi:type='uml:PrimitiveType' or @xmi:type='uml:DataType']">
<xsl:variable name="id" select="@xmi:id"/>
<primitiveTypes id="{@xmi:id}">
  <xsl:attribute name="name"><xsl:value-of select="@name"/></xsl:attribute>
  <xsl:attribute name="usedByElements">
  <xsl:for-each select="key('parametersByType', @xmi:id)"><xsl:value-of select="../@xmi:id"/><xsl:text>_</xsl:text><xsl:value-of select="@name"/><xsl:text> </xsl:text></xsl:for-each>
  <xsl:for-each select="key('operationsByType', @xmi:id)"><xsl:value-of select="../@xmi:id"/><xsl:text> </xsl:text></xsl:for-each>
  <xsl:for-each select="key('attributesByType', @xmi:id)"><xsl:value-of select="@xmi:id"/><xsl:text> </xsl:text></xsl:for-each>
  </xsl:attribute>
</primitiveTypes>
</xsl:template>

<!-- ************************************************************* -->
<!-- Classes -->
<!-- ************************************************************* -->
<xsl:template match="packagedElement[@xmi:type='uml:Class']">
<classifiers xsi:type="model.classes:UMLClass" id="{@xmi:id}">
  <xsl:variable name="id" select="@xmi:id" />
  <xsl:attribute name="name"><xsl:value-of select="@name"/></xsl:attribute>
  <xsl:attribute name="visibility"><xsl:call-template name="visibility"/></xsl:attribute>
  <xsl:attribute name="isAbstract"><xsl:value-of select="@isAbstract"/><xsl:if test="not(@isAbstract)">false</xsl:if></xsl:attribute>
  <xsl:attribute name="isFinal"><xsl:value-of select="@isFinal"/><xsl:if test="not(@isFinal)">false</xsl:if></xsl:attribute>
  <xsl:attribute name="usedByElements">
  <xsl:for-each select="key('parametersByType', @xmi:id)"><xsl:value-of select="../@xmi:id"/><xsl:text>_</xsl:text><xsl:value-of select="@name"/><xsl:text> </xsl:text></xsl:for-each>
  <xsl:for-each select="key('operationsByType', @xmi:id)"><xsl:value-of select="../@xmi:id"/><xsl:text> </xsl:text></xsl:for-each>
  <xsl:for-each select="key('attributesByType', @xmi:id)"><xsl:value-of select="@xmi:id"/><xsl:text> </xsl:text></xsl:for-each>
  </xsl:attribute>
  <xsl:attribute name="targetedByAssociationEnds">
    <xsl:for-each select="//ownedAttribute[@association and @type=$id]"><xsl:value-of select="@xmi:id"/><xsl:text> </xsl:text></xsl:for-each>
    <xsl:for-each select="//ownedEnd[@association and @type=$id]"><xsl:value-of select="@xmi:id"/><xsl:text> </xsl:text></xsl:for-each>
  </xsl:attribute>
  <xsl:attribute name="specializations"><xsl:for-each select="//generalization[@general=$id]"><xsl:value-of select="@xmi:id"/><xsl:text> </xsl:text></xsl:for-each></xsl:attribute>
  <xsl:attribute name="dependees"><xsl:for-each select="//packagedElement[@xmi:type='uml:Dependency' and @supplier=$id]"><xsl:value-of select="@xmi:id"/><xsl:text> </xsl:text></xsl:for-each></xsl:attribute>
  <xsl:apply-templates select="./ownedAttribute[not(@association)]"/>
  <xsl:apply-templates select="./ownedOperation"/>
  <xsl:apply-templates select="./generalization"/>
  <!-- Dependencies -->
  <xsl:for-each select="//packagedElement[@xmi:type='uml:Dependency' and @client=$id]">
   <outgoingDependencies id="{@xmi:id}">
   <xsl:attribute name="supplier"><xsl:value-of select="@supplier"/></xsl:attribute>
   <xsl:attribute name="dependee"><xsl:value-of select="$id"/></xsl:attribute>
   <xsl:attribute name="name"><xsl:value-of select="@name"/></xsl:attribute>
   </outgoingDependencies>
  </xsl:for-each>
</classifiers>
</xsl:template>

<!-- ************************************************************* -->
<!-- Interfaces -->
<!-- ************************************************************* -->
<xsl:template match="packagedElement[@xmi:type='uml:Interface']">
<classifiers xsi:type="model.classes:UMLInterface" id="{@xmi:id}">
  <xsl:variable name="id" select="@xmi:id" />
  <xsl:attribute name="name"><xsl:value-of select="@name"/></xsl:attribute>
  <xsl:attribute name="visibility"><xsl:call-template name="visibility"/></xsl:attribute>
  <xsl:attribute name="usedByElements">
  <xsl:for-each select="key('parametersByType', @xmi:id)"><xsl:value-of select="../@xmi:id"/><xsl:text>_</xsl:text><xsl:value-of select="@name"/><xsl:text> </xsl:text></xsl:for-each>
  <xsl:for-each select="key('operationsByType', @xmi:id)"><xsl:value-of select="../@xmi:id"/><xsl:text> </xsl:text></xsl:for-each>
  <xsl:for-each select="key('attributesByType', @xmi:id)"><xsl:value-of select="@xmi:id"/><xsl:text> </xsl:text></xsl:for-each>
  </xsl:attribute>
  <xsl:attribute name="targetedByAssociationEnds">
    <xsl:for-each select="//ownedAttribute[@association and @type=$id]"><xsl:value-of select="@xmi:id"/><xsl:text> </xsl:text></xsl:for-each>
    <xsl:for-each select="//ownedEnd[@association and @type=$id]"><xsl:value-of select="@xmi:id"/><xsl:text> </xsl:text></xsl:for-each>
  </xsl:attribute>
  <xsl:attribute name="specializations"><xsl:for-each select="//generalization[@general=$id]"><xsl:value-of select="@xmi:id"/><xsl:text> </xsl:text></xsl:for-each></xsl:attribute>
  <xsl:attribute name="dependees"><xsl:for-each select="//packagedElement[@xmi:type='uml:Dependency' and @supplier=$id]"><xsl:value-of select="@xmi:id"/><xsl:text> </xsl:text></xsl:for-each></xsl:attribute>
  <xsl:apply-templates select="./ownedAttribute[not(@association)]"/>
  <xsl:apply-templates select="./ownedOperation"/>
  <xsl:apply-templates select="./generalization"/>
  <!-- Dependencies -->
  <xsl:for-each select="//packagedElement[@xmi:type='uml:Dependency' and @client=$id]">
   <outgoingDependencies id="{@xmi:id}">
   <xsl:attribute name="supplier"><xsl:value-of select="@supplier"/></xsl:attribute>
   <xsl:attribute name="dependee"><xsl:value-of select="$id"/></xsl:attribute>
   <xsl:attribute name="name"><xsl:value-of select="@name"/></xsl:attribute>
   </outgoingDependencies>
  </xsl:for-each>
</classifiers>
</xsl:template>

<!-- ************************************************************* -->
<!-- Attributes -->
<!-- ************************************************************* -->
<xsl:template match="ownedAttribute[not(@association)]">
<attributes id="{@xmi:id}">
  <xsl:attribute name="name"><xsl:value-of select="@name"/></xsl:attribute>
  <xsl:attribute name="visibility"><xsl:call-template name="visibility"/></xsl:attribute>
  <xsl:attribute name="isStatic"><xsl:value-of select="@isStatic"/><xsl:if test="not(@isStatic)">false</xsl:if></xsl:attribute>
  <xsl:attribute name="isFinal"><xsl:value-of select="@isFinal"/><xsl:if test="not(@isFinal)">false</xsl:if></xsl:attribute>
  <xsl:attribute name="isReadOnly"><xsl:value-of select="@isReadOnly"/><xsl:if test="not(@isReadOnly)">false</xsl:if></xsl:attribute>
  <xsl:if test="./type">
  	<xsl:attribute name="type"><xsl:apply-templates select="./type/@href"/></xsl:attribute>
  </xsl:if>
  <xsl:if test="@type">
  	<xsl:attribute name="type"><xsl:value-of select="@type"/></xsl:attribute>
  </xsl:if>
</attributes>
</xsl:template>


<!-- ************************************************************* -->
<!-- Operations -->
<!-- ************************************************************* -->
<xsl:template match="ownedOperation">
<operations id="{@xmi:id}">
  <xsl:attribute name="name"><xsl:value-of select="@name"/></xsl:attribute>
  <xsl:attribute name="visibility"><xsl:call-template name="visibility"/></xsl:attribute>
  <xsl:attribute name="isStatic"><xsl:value-of select="@isStatic"/><xsl:if test="not(@isStatic)">false</xsl:if></xsl:attribute>
  <xsl:attribute name="isAbstract"><xsl:value-of select="@isAbstract"/><xsl:if test="not(@isAbstract)">false</xsl:if></xsl:attribute>
  <xsl:attribute name="type">
    <xsl:if test="./ownedParameter[@direction='return']/@type">
      <xsl:value-of select="./ownedParameter[@direction='return']/@type"/>
    </xsl:if>
    <xsl:if test="./ownedParameter[@direction='return']/type">
      <xsl:apply-templates select="./ownedParameter/type/@href"/>
    </xsl:if>
  </xsl:attribute>
  <xsl:apply-templates select="./ownedParameter[not(@direction='return')]"/>
</operations>
</xsl:template>


<!-- ************************************************************* -->
<!-- Parameters -->
<!-- ************************************************************* -->
<xsl:template match="ownedParameter">
<parameters id="{../@xmi:id}_{@name}">
  <xsl:attribute name="name"><xsl:value-of select="@name"/></xsl:attribute>
  <xsl:if test="./type">
  	<xsl:attribute name="type"><xsl:apply-templates select="./type/@href"/></xsl:attribute>
  </xsl:if>
  <xsl:if test="@type">
  	<xsl:attribute name="type"><xsl:value-of select="@type"/></xsl:attribute>
  </xsl:if>
  <xsl:attribute name="kind"><xsl:call-template name="kind"/></xsl:attribute>
</parameters>
</xsl:template>

<!-- ************************************************************* -->
<!-- Generalizations -->
<!-- ************************************************************* -->
<xsl:template match="generalization">
<generalizations id="{@xmi:id}">
  <xsl:attribute name="generalElement"><xsl:value-of select="@general"/></xsl:attribute>
  <xsl:attribute name="specialElement"><xsl:value-of select="../@xmi:id"/></xsl:attribute>
</generalizations>
</xsl:template>

<!-- ************************************************************* -->
<!-- Associations -->
<!-- ************************************************************* -->
<xsl:template match="packagedElement[@xmi:type='uml:Association']">
<associations id="{@xmi:id}">
  <xsl:variable name="id" select="@xmi:id" />
  <xsl:attribute name="name"><xsl:value-of select="@name"/></xsl:attribute>
  <!-- <xsl:apply-templates select=".//UML:Attribute"/> gibts das bei Rational??? -->
  <xsl:apply-templates select="//ownedAttribute[@association=$id]"/>
  <xsl:apply-templates select="//ownedEnd[@association=$id]"/>
</associations>
</xsl:template>


<xsl:template match="ownedAttribute[@association]">
<associationEnds id="{@xmi:id}">
  <xsl:attribute name="name"><xsl:value-of select="@name"/></xsl:attribute>
  <xsl:attribute name="multiplicity"><xsl:value-of select="./lowerValue/@value"/><xsl:if test="./lowerValue/@value">..</xsl:if><xsl:value-of select="./upperValue/@value"/><xsl:if test="not(./upperValue/@value)">1</xsl:if></xsl:attribute>
  <xsl:attribute name="isNavigable">true</xsl:attribute>
  <xsl:attribute name="isOrdered"><xsl:value-of select="@isOrdered"/><xsl:if test="not(@isOrdered)">false</xsl:if></xsl:attribute>
  <xsl:attribute name="kind"><xsl:call-template name="aggregation"/></xsl:attribute>
  <xsl:attribute name="target"><xsl:value-of select="@type"/></xsl:attribute>
</associationEnds>
</xsl:template>

<xsl:template match="ownedEnd[@association]">
<associationEnds id="{@xmi:id}">
  <xsl:attribute name="name"><xsl:value-of select="@name"/></xsl:attribute>
  <xsl:attribute name="multiplicity">0</xsl:attribute>
  <xsl:attribute name="isNavigable">false</xsl:attribute>
  <xsl:attribute name="isOrdered">false</xsl:attribute>
  <xsl:attribute name="kind">none</xsl:attribute>
  <xsl:attribute name="target"><xsl:value-of select="@type"/></xsl:attribute>
</associationEnds>
</xsl:template>

<xsl:template match="packagedElement[@xmi:type='uml:AssociationClass']">
<associations xsi:type="model.classes:UMLAssociationClass"  id="{@xmi:id}">
  <xsl:variable name="id" select="@xmi:id" />
  <xsl:attribute name="name"><xsl:value-of select="@name"/></xsl:attribute>
  <!-- <xsl:apply-templates select=".//UML:Attribute"/> gibts das bei Rational??? -->
  <xsl:apply-templates select="//ownedAttribute[@association=$id]"/>
  <xsl:apply-templates select="//ownedEnd[@association=$id]"/>
  <xsl:apply-templates select="./ownedAttribute[not(@association)]"/>
  <xsl:apply-templates select="./ownedOperation"/>
  <xsl:apply-templates select="./generalization"/>
</associations>
</xsl:template>

<!-- ************************************************************* -->
<!-- Enumerations -->
<!-- ************************************************************* -->
<xsl:template match="packagedElement[@xmi:type='uml:Enumeration']">
<xsl:variable name="id" select="@xmi:id"/>
<enumerations id="{@xmi:id}">
  <xsl:attribute name="name"><xsl:value-of select="@name"/></xsl:attribute>
  <xsl:attribute name="usedByElements">
  <xsl:for-each select="key('parametersByType', @xmi:id)"><xsl:value-of select="../@xmi:id"/><xsl:text>_</xsl:text><xsl:value-of select="@name"/><xsl:text> </xsl:text></xsl:for-each>
  <xsl:for-each select="key('operationsByType', @xmi:id)"><xsl:value-of select="../@xmi:id"/><xsl:text> </xsl:text></xsl:for-each>
  <xsl:for-each select="key('attributesByType', @xmi:id)"><xsl:value-of select="@xmi:id"/><xsl:text> </xsl:text></xsl:for-each>
  </xsl:attribute>
  <xsl:apply-templates select="./ownedLiteral"/>
</enumerations>
</xsl:template>

<!-- ************************************************************* -->
<!-- Literals -->
<!-- ************************************************************* -->
<xsl:template match="ownedLiteral">
<xsl:variable name="id" select="@xmi:id"/>
<literals id="{@xmi:id}">
  <xsl:attribute name="name"><xsl:value-of select="@name"/></xsl:attribute>
</literals>
</xsl:template>

<!-- ************************************************************* -->
<!-- Translation of visibility values -->
<!-- ************************************************************* -->
<xsl:template name="visibility">
<xsl:choose>
<xsl:when test="@visibility='public'">public</xsl:when>
<xsl:when test="@visibility='protected'">protected</xsl:when>
<xsl:when test="@visibility='private'">private</xsl:when>
<xsl:otherwise>package</xsl:otherwise>
</xsl:choose>
</xsl:template>

<!-- ************************************************************* -->
<!-- Translation of aggregation kind values -->
<!-- ************************************************************* -->
<xsl:template name="aggregation">
<xsl:choose>
<xsl:when test="@aggregation='composite'">composite</xsl:when>
<xsl:when test="@aggregation='aggregate'">shared</xsl:when>
<xsl:otherwise>none</xsl:otherwise>
</xsl:choose>
</xsl:template>

<!-- ************************************************************* -->
<!-- Translation of parameter kind values -->
<!-- ************************************************************* -->
<xsl:template name="kind">
<xsl:choose>
<xsl:when test="@kind='in'">in</xsl:when>
<xsl:otherwise>inout</xsl:otherwise>
</xsl:choose>
</xsl:template>


</xsl:transform>