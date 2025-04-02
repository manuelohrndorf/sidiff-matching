org.sidiff.common.Activator -> org.sidiff.common.a:
    org.osgi.framework.BundleContext context -> a
    void start(org.osgi.framework.BundleContext) -> start
    void stop(org.osgi.framework.BundleContext) -> stop
    org.osgi.framework.BundleContext getBundleContext() -> a
    boolean isActivated() -> b
org.sidiff.common.app.CommandLine -> org.sidiff.common.app.a:
    java.lang.String PARAMETER_PREFIX -> a
    java.util.List arguments -> b
    java.util.Map parameterMap -> c
    java.util.Map flagMap -> d
    org.sidiff.common.app.CommandLine$Argument createArgument(boolean) -> a
    org.sidiff.common.app.CommandLine$Argument createFlag(java.lang.String) -> a
    org.sidiff.common.app.CommandLine$Argument createParameter(java.lang.String,java.lang.Class,boolean) -> a
    boolean parse(java.lang.String[],boolean) -> a
org.sidiff.common.app.CommandLine$Argument -> org.sidiff.common.app.b:
    java.lang.Class type -> a
    java.lang.Object value -> b
    boolean satisfied -> c
    void setValue(java.lang.String) -> a
    java.lang.Object getValue() -> a
    void access$1(org.sidiff.common.app.CommandLine$Argument,java.lang.String) -> a
    java.lang.Class access$2(org.sidiff.common.app.CommandLine$Argument) -> a
    boolean access$3(org.sidiff.common.app.CommandLine$Argument) -> b
org.sidiff.common.collections.ClassificationUtil -> org.sidiff.common.collections.n:
    java.util.Map classifiedLists(java.util.Collection,org.sidiff.common.collections.Classifier) -> a
    java.util.Map classifiedSets(java.util.Collection,org.sidiff.common.collections.Classifier) -> b
    java.util.Map computeMap(java.util.Collection,org.sidiff.common.collections.Classifier) -> c
    java.util.SortedMap sortedClassifiedLists(java.util.Collection,org.sidiff.common.collections.Classifier,java.util.Comparator) -> a
    java.util.SortedMap sortedClassifiedSets(java.util.Collection,org.sidiff.common.collections.Classifier,java.util.Comparator) -> b
org.sidiff.common.collections.Classifier -> org.sidiff.common.collections.Classifier:
    java.lang.Object classify(java.lang.Object) -> a
org.sidiff.common.collections.CollectionUtil -> org.sidiff.common.collections.c:
    boolean containSameElements(java.util.Vector,java.util.Vector) -> a
    java.lang.Iterable iterableFrom(java.util.Iterator) -> a
org.sidiff.common.collections.CollectionUtil$1 -> org.sidiff.common.collections.i:
    java.util.ArrayList list -> a
    java.util.Iterator iterator() -> iterator
org.sidiff.common.collections.CrossMap -> org.sidiff.common.collections.k:
    java.util.Map map -> a
    java.util.Map rMap -> b
    void clear() -> clear
    boolean containsKey(java.lang.Object) -> containsKey
    boolean containsValue(java.lang.Object) -> containsValue
    java.lang.Object get(java.lang.Object) -> get
    java.lang.Object getKey(java.lang.Object) -> a
    boolean isEmpty() -> isEmpty
    java.util.Set keySet() -> keySet
    java.lang.Object put(java.lang.Object,java.lang.Object) -> put
    java.lang.Object remove(java.lang.Object) -> remove
    int size() -> size
    java.lang.String toString() -> toString
    java.util.Collection values() -> values
    java.util.Set entrySet() -> entrySet
    void putAll(java.util.Map) -> putAll
org.sidiff.common.collections.DefaultComperators -> org.sidiff.common.collections.j:
    java.util.Comparator hashObjectComperator -> a
    java.util.Comparator getHashComparator(java.lang.Class) -> a
org.sidiff.common.collections.DefaultComperators$1 -> org.sidiff.common.collections.d:
    int compare(java.lang.Object,java.lang.Object) -> compare
org.sidiff.common.collections.DefaultSelectors -> org.sidiff.common.collections.e:
    org.sidiff.common.collections.Selector anythingSelector -> a
    org.sidiff.common.collections.Selector nothingSelector -> b
    org.sidiff.common.collections.Selector anything() -> a
    org.sidiff.common.collections.Selector nothing() -> b
    org.sidiff.common.collections.Selector anyoneOf(java.util.Collection) -> a
org.sidiff.common.collections.DefaultSelectors$1 -> org.sidiff.common.collections.a:
    boolean select(java.lang.Object) -> a
org.sidiff.common.collections.DefaultSelectors$2 -> org.sidiff.common.collections.b:
    boolean select(java.lang.Object) -> a
org.sidiff.common.collections.DefaultSelectors$CollectionSelector -> org.sidiff.common.collections.h:
    java.util.Collection items -> a
    boolean select(java.lang.Object) -> a
org.sidiff.common.collections.FilterUtil -> org.sidiff.common.collections.l:
    java.util.Set filter(java.util.Collection,boolean,org.sidiff.common.collections.Selector) -> a
    java.util.Set filter(java.util.Set,boolean,org.sidiff.common.collections.Selector) -> a
    java.util.List filter(java.util.List,boolean,org.sidiff.common.collections.Selector) -> a
    java.util.Set includeAll(java.util.Set,org.sidiff.common.collections.Selector) -> a
    java.util.Set excludeAll(java.util.Set,org.sidiff.common.collections.Selector) -> b
org.sidiff.common.collections.MapWithDefault -> org.sidiff.common.collections.o:
    java.lang.Object default_value -> b
    java.util.Map decorated -> c
    boolean $assertionsDisabled -> a
    boolean setDefaultValue(java.lang.Object) -> a
    java.lang.Object getDefaultValue() -> a
    void clear() -> clear
    boolean containsKey(java.lang.Object) -> containsKey
    boolean containsValue(java.lang.Object) -> containsValue
    java.util.Set entrySet() -> entrySet
    java.lang.Object get(java.lang.Object) -> get
    boolean isEmpty() -> isEmpty
    java.util.Set keySet() -> keySet
    java.lang.Object put(java.lang.Object,java.lang.Object) -> put
    void putAll(java.util.Map) -> putAll
    java.lang.Object remove(java.lang.Object) -> remove
    int size() -> size
    java.util.Collection values() -> values
    boolean equals(java.lang.Object) -> equals
    int hashCode() -> hashCode
    java.lang.String toString() -> toString
org.sidiff.common.collections.Selector -> org.sidiff.common.collections.Selector:
    boolean select(java.lang.Object) -> a
org.sidiff.common.collections.SetUtil -> org.sidiff.common.collections.f:
    java.util.Set Union(java.util.Set[]) -> a
    java.util.List Union(java.util.Collection[]) -> a
    java.util.Set Intersection(java.util.Set,java.util.Set) -> a
    java.util.Set Intersection(java.util.Set,java.util.Set,java.util.Set[]) -> a
    java.util.Set DifferenceA(java.util.Set,java.util.Set) -> b
    java.util.Set DifferenceB(java.util.Set,java.util.Set) -> c
    java.util.Set SymmetricDifference(java.util.Set,java.util.Set) -> d
org.sidiff.common.collections.ValueMap -> org.sidiff.common.collections.g:
    java.util.Map value2objects -> a
    java.util.Map objects2value -> b
    java.util.Set getValues() -> a
    java.lang.Object getValue(java.lang.Object) -> a
    java.util.Collection getObjects(java.lang.Object) -> b
    java.util.Set getValuedObjects() -> b
    boolean isUnique(java.lang.Object) -> c
    void put(java.lang.Object,java.lang.Object) -> a
    void remove(java.lang.Object) -> d
    void insert(org.sidiff.common.collections.ValueMap) -> a
    java.util.Set getFilledValues(int) -> a
org.sidiff.common.collections.ViewUtil -> org.sidiff.common.collections.m:
    java.util.Collection unifiedCollectionView(java.util.Collection) -> a
    java.util.Set unifiedSetView(java.util.Collection) -> b
    java.util.List unifiedListView(java.util.Collection) -> c
    java.util.Collection filteredCollectionView(java.util.Collection,org.sidiff.common.collections.Selector,boolean) -> a
    java.util.Set filteredSetView(java.util.Set,org.sidiff.common.collections.Selector,boolean) -> a
    java.util.List filteredListView(java.util.List,org.sidiff.common.collections.Selector,boolean) -> a
    java.util.Iterator filteredIteratorView(java.util.Iterator,org.sidiff.common.collections.Selector,boolean) -> a
    java.util.Collection iteratorCollectionView(java.util.Iterator) -> a
    java.util.List iteratorListView(java.util.Iterator) -> b
    java.util.Set iteratorSetView(java.util.Iterator) -> c
org.sidiff.common.collections.internal.FilteredCollectionView -> org.sidiff.common.collections.internal.b:
    java.util.Collection collection -> a
    org.sidiff.common.collections.Selector selector -> b
    boolean include -> c
    boolean contains(java.lang.Object) -> contains
    boolean containsAll(java.util.Collection) -> containsAll
    boolean isEmpty() -> isEmpty
    java.util.Iterator iterator() -> iterator
    int size() -> size
    java.lang.Object[] toArray() -> toArray
    java.lang.Object[] toArray(java.lang.Object[]) -> toArray
org.sidiff.common.collections.internal.FilteredIteratorView -> org.sidiff.common.collections.internal.m:
    java.util.Iterator iterator -> c
    org.sidiff.common.collections.Selector selector -> a
    boolean include -> b
    java.lang.Object nextItem -> d
    boolean hasNext() -> hasNext
    java.lang.Object next() -> next
    void proceed() -> a
org.sidiff.common.collections.internal.FilteredListIterator -> org.sidiff.common.collections.internal.h:
    java.util.List list -> c
    int i -> d
    void add(java.lang.Object) -> add
    boolean hasPrevious() -> hasPrevious
    int nextIndex() -> nextIndex
    java.lang.Object previous() -> previous
    int previousIndex() -> previousIndex
    void set(java.lang.Object) -> set
    boolean hasNext() -> hasNext
    java.lang.Object next() -> next
org.sidiff.common.collections.internal.FilteredListView -> org.sidiff.common.collections.internal.g:
    java.util.List list -> a
    org.sidiff.common.collections.Selector selector -> b
    boolean include -> c
    void add(int,java.lang.Object) -> add
    boolean addAll(int,java.util.Collection) -> addAll
    java.lang.Object get(int) -> get
    int indexOf(java.lang.Object) -> indexOf
    int lastIndexOf(java.lang.Object) -> lastIndexOf
    java.util.ListIterator listIterator() -> listIterator
    java.util.ListIterator listIterator(int) -> listIterator
    java.lang.Object remove(int) -> remove
    java.lang.Object set(int,java.lang.Object) -> set
    java.util.List subList(int,int) -> subList
org.sidiff.common.collections.internal.FilteredSetView -> org.sidiff.common.collections.internal.j:
org.sidiff.common.collections.internal.IteratorCollectionView -> org.sidiff.common.collections.internal.f:
    java.util.Iterator underlyingIterator -> a
    java.util.List traversedElements -> b
    boolean contains(java.lang.Object) -> contains
    boolean containsAll(java.util.Collection) -> containsAll
    boolean isEmpty() -> isEmpty
    java.util.Iterator iterator() -> iterator
    int size() -> size
    java.lang.Object[] toArray() -> toArray
    java.lang.Object[] toArray(java.lang.Object[]) -> toArray
    boolean performCopyAll() -> a
    java.lang.Object performCopyStep() -> b
org.sidiff.common.collections.internal.IteratorCollectionView$IteratorCollectionViewIterator -> org.sidiff.common.collections.internal.i:
    java.util.Iterator traversedElementsIterator -> a
    org.sidiff.common.collections.internal.IteratorCollectionView this$0 -> b
    boolean hasNext() -> hasNext
    java.lang.Object next() -> next
org.sidiff.common.collections.internal.IteratorListView -> org.sidiff.common.collections.internal.e:
    void add(int,java.lang.Object) -> add
    boolean addAll(int,java.util.Collection) -> addAll
    java.lang.Object remove(int) -> remove
    java.lang.Object set(int,java.lang.Object) -> set
    java.lang.Object get(int) -> get
    int indexOf(java.lang.Object) -> indexOf
    int lastIndexOf(java.lang.Object) -> lastIndexOf
    java.util.ListIterator listIterator() -> listIterator
    java.util.ListIterator listIterator(int) -> listIterator
    java.util.List subList(int,int) -> subList
org.sidiff.common.collections.internal.IteratorListView$IteratorListViewIterator -> org.sidiff.common.collections.internal.k:
    int fromIndex -> d
    org.sidiff.common.collections.internal.IteratorListView this$0 -> c
    void add(java.lang.Object) -> add
    void remove() -> remove
    void set(java.lang.Object) -> set
    boolean hasPrevious() -> hasPrevious
    int nextIndex() -> nextIndex
    java.lang.Object previous() -> previous
    int previousIndex() -> previousIndex
org.sidiff.common.collections.internal.IteratorSetView -> org.sidiff.common.collections.internal.o:
org.sidiff.common.collections.internal.ReadOnlyCollection -> org.sidiff.common.collections.internal.d:
    boolean add(java.lang.Object) -> add
    boolean addAll(java.util.Collection) -> addAll
    void clear() -> clear
    boolean remove(java.lang.Object) -> remove
    boolean removeAll(java.util.Collection) -> removeAll
    boolean retainAll(java.util.Collection) -> retainAll
org.sidiff.common.collections.internal.ReadOnlyIterator -> org.sidiff.common.collections.internal.p:
    void remove() -> remove
org.sidiff.common.collections.internal.UnifiedCollectionIterator -> org.sidiff.common.collections.internal.q:
    java.util.List iterators -> a
    boolean hasNext() -> hasNext
    java.lang.Object next() -> next
org.sidiff.common.collections.internal.UnifiedCollectionView -> org.sidiff.common.collections.internal.c:
    java.util.Collection collections -> a
    boolean contains(java.lang.Object) -> contains
    boolean containsAll(java.util.Collection) -> containsAll
    boolean isEmpty() -> isEmpty
    java.util.Iterator iterator() -> iterator
    int size() -> size
    java.lang.Object[] toArray() -> toArray
    java.lang.Object[] toArray(java.lang.Object[]) -> toArray
org.sidiff.common.collections.internal.UnifiedListIterator -> org.sidiff.common.collections.internal.l:
    int superIndex -> a
    int thisIndex -> b
    java.util.List baseList -> c
    void add(java.lang.Object) -> add
    boolean hasPrevious() -> hasPrevious
    int nextIndex() -> nextIndex
    java.lang.Object previous() -> previous
    int previousIndex() -> previousIndex
    void set(java.lang.Object) -> set
    boolean hasNext() -> hasNext
    java.lang.Object next() -> next
    void remove() -> remove
org.sidiff.common.collections.internal.UnifiedListView -> org.sidiff.common.collections.internal.n:
    java.util.Collection lists -> a
    void add(int,java.lang.Object) -> add
    boolean addAll(int,java.util.Collection) -> addAll
    java.lang.Object get(int) -> get
    int indexOf(java.lang.Object) -> indexOf
    int lastIndexOf(java.lang.Object) -> lastIndexOf
    java.util.ListIterator listIterator() -> listIterator
    java.util.ListIterator listIterator(int) -> listIterator
    java.lang.Object remove(int) -> remove
    java.lang.Object set(int,java.lang.Object) -> set
    java.util.List subList(int,int) -> subList
org.sidiff.common.collections.internal.UnifiedSetView -> org.sidiff.common.collections.internal.a:
org.sidiff.common.crypto.Command -> org.sidiff.common.crypto.Command:
    void decrypt(java.lang.String[]) -> a
    void encrypt(java.lang.String[]) -> b
    void generatekeys(java.lang.String[]) -> c
    void sign(java.lang.String[]) -> d
    void verify(java.lang.String[]) -> e
    void xmlsign(java.lang.String[]) -> f
    void xmlverify(java.lang.String[]) -> g
    void main(java.lang.String[]) -> main
org.sidiff.common.crypto.CryptoUtil -> org.sidiff.common.crypto.g:
    java.lang.String DIGEST_ALGO -> b
    boolean $assertionsDisabled -> a
    java.lang.String byteArrayToHexString(byte[]) -> a
    java.lang.String XMLStringFromNode(org.w3c.dom.Node) -> a
    java.lang.String md5SumForNodeList(org.w3c.dom.NodeList) -> a
    java.util.ArrayList MD5SumsForXML(java.io.InputStream,java.util.ArrayList) -> a
    java.util.ArrayList MD5SumsForDocument(org.w3c.dom.Document,java.util.ArrayList) -> a
    byte[] readInputStream(java.io.InputStream) -> a
org.sidiff.common.crypto.Decrypter -> org.sidiff.common.crypto.b:
    boolean $assertionsDisabled -> a
    void decrypt(java.io.InputStream,java.io.OutputStream) -> a
org.sidiff.common.crypto.DecryptionStream -> org.sidiff.common.crypto.d:
    javax.crypto.CipherInputStream cipherInputStream -> a
    javax.crypto.Cipher cipher -> b
org.sidiff.common.crypto.Encrypter -> org.sidiff.common.crypto.l:
    boolean $assertionsDisabled -> a
    void encrypt(java.io.InputStream,java.io.OutputStream) -> a
    void encryptFile(java.lang.String,java.lang.String) -> a
org.sidiff.common.crypto.EncryptionManager -> org.sidiff.common.crypto.h:
    org.sidiff.common.crypto.EncryptionManager mInstance -> b
    javax.crypto.SecretKey mSecretKey -> c
    java.lang.String algorithm -> d
    int keySize -> e
    boolean $assertionsDisabled -> a
    org.sidiff.common.crypto.EncryptionManager getInstance() -> a
    void loadSecretKey(java.io.InputStream) -> a
    void loadSecretKeyFromFile(java.lang.String) -> a
    javax.crypto.SecretKey getSecretKey() -> b
    javax.crypto.Cipher getSymetricCipher(boolean) -> a
    void writeExampleKey(java.io.OutputStream) -> a
    void writeExampleKeyToFile(java.lang.String) -> b
org.sidiff.common.crypto.EncryptionStream -> org.sidiff.common.crypto.c:
org.sidiff.common.crypto.SignatureManager -> org.sidiff.common.crypto.j:
    java.lang.String KEY_ALGO -> b
    org.sidiff.common.crypto.SignatureManager mInstance -> c
    java.security.PublicKey mPublicKey -> d
    java.security.PrivateKey mPrivateKey -> e
    boolean $assertionsDisabled -> a
    org.sidiff.common.crypto.SignatureManager getInstance() -> a
    void loadSignatureKeys(java.io.InputStream,java.io.InputStream) -> a
    void loadSignatureKeysFromFile(java.lang.String,java.lang.String) -> a
    java.security.PublicKey getPublicKey() -> b
    java.security.PrivateKey getPrivateKey() -> c
    void writeExampleKeys(java.io.OutputStream,java.io.OutputStream) -> a
    void writeExampleKeysToFiles(java.lang.String,java.lang.String) -> b
org.sidiff.common.crypto.Signer -> org.sidiff.common.crypto.e:
    java.lang.String SIGN_ALGO -> b
    boolean $assertionsDisabled -> a
    void sign(java.io.InputStream,java.io.OutputStream) -> a
    void signFile(java.lang.String,java.lang.String) -> a
org.sidiff.common.crypto.Verifier -> org.sidiff.common.crypto.i:
    java.lang.String VERIFY_ALGO -> b
    boolean $assertionsDisabled -> a
    boolean verify(java.io.InputStream,java.io.InputStream) -> a
    boolean verifyFile(java.lang.String,java.lang.String) -> a
org.sidiff.common.crypto.XMLSigner -> org.sidiff.common.crypto.k:
    java.util.ArrayList mXPaths -> b
    boolean $assertionsDisabled -> a
    void reset() -> a
    void addXPathToSign(java.lang.String) -> a
    void signXML(java.io.InputStream,java.io.OutputStream,java.io.OutputStream) -> a
    void signDocument(org.w3c.dom.Document,java.io.OutputStream,java.io.OutputStream) -> a
    void signXMLFile(java.lang.String,java.lang.String,java.lang.String) -> a
org.sidiff.common.crypto.XMLVerifier -> org.sidiff.common.crypto.f:
    boolean $assertionsDisabled -> a
    boolean compareMD5s(java.util.ArrayList,java.util.ArrayList) -> a
    org.sidiff.common.crypto.XMLVerifier$XMLInfo processSignature(java.io.InputStream,java.io.InputStream) -> a
    boolean verifyXML(java.io.InputStream,java.io.InputStream,java.io.InputStream) -> a
    boolean verifyDocument(org.w3c.dom.Document,java.io.InputStream,java.io.InputStream) -> a
    boolean verifyXMLFile(java.lang.String,java.lang.String,java.lang.String) -> a
org.sidiff.common.crypto.XMLVerifier$XMLInfo -> org.sidiff.common.crypto.a:
    boolean verified -> a
    java.util.ArrayList xPaths -> b
    java.util.ArrayList md5sFromSigInfo -> c
    org.sidiff.common.crypto.XMLVerifier this$0 -> d
org.sidiff.common.emf.Activator -> org.sidiff.common.emf.b:
    java.lang.String BUNDLE_ID -> a
    org.eclipse.emf.common.notify.AdapterFactory annotationsAdapterFactory -> b
    org.sidiff.common.util.internal.StringResolver eObjectStringResolver -> c
    java.util.Collection providedServices -> d
    void start(org.osgi.framework.BundleContext) -> start
    void stop(org.osgi.framework.BundleContext) -> stop
org.sidiff.common.emf.EMFAdapter -> org.sidiff.common.emf.i:
    java.util.List factories -> b
    org.sidiff.common.emf.EMFAdapter INSTANCE -> a
    boolean addAdapterFactory(org.eclipse.emf.common.notify.AdapterFactory) -> a
    boolean removeAdapterFactory(org.eclipse.emf.common.notify.AdapterFactory) -> b
    java.lang.Object adapt(org.eclipse.emf.ecore.EObject,java.lang.Class) -> a
org.sidiff.common.emf.EMFDebug -> org.sidiff.common.emf.d:
    void countModel(org.eclipse.emf.ecore.resource.Resource) -> a
    boolean checkModelID(org.eclipse.emf.ecore.resource.Resource,java.lang.String) -> a
org.sidiff.common.emf.EMFMetaObjectExtender -> org.sidiff.common.emf.c:
    org.eclipse.emf.ecore.EPackage ePackage -> a
    java.util.Map map -> b
    java.lang.Object putData(java.lang.String,java.lang.Object) -> a
    java.lang.Object putData(org.eclipse.emf.ecore.EClassifier,java.lang.Object) -> a
    java.lang.Object getDataByInstance(org.eclipse.emf.ecore.EObject) -> a
    java.lang.Object getDataByMetaObject(org.eclipse.emf.ecore.EClassifier) -> a
    java.util.Collection values() -> a
    java.util.Set keySet() -> b
org.sidiff.common.emf.EMFResourceHasher -> org.sidiff.common.emf.g:
    java.lang.String hash(org.eclipse.emf.ecore.resource.Resource) -> a
org.sidiff.common.emf.EMFUtil -> org.sidiff.common.emf.j:
    boolean isAnnotatedWith(org.eclipse.emf.ecore.EObject,java.lang.String) -> a
    void loadEcoreModelFromResource(java.lang.String) -> a
    void registerEPackage(org.eclipse.emf.ecore.EPackage) -> a
    java.util.List getObjectListFromReference(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EReference) -> a
    java.util.List fillObjectListFromReference(java.util.List,org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EReference) -> a
    java.util.List getEAllContentsAsList(org.eclipse.emf.ecore.EObject) -> a
    int getEAllContentsSize(org.eclipse.emf.ecore.EObject) -> b
    java.util.List getEAllContentsAsList(org.eclipse.emf.ecore.resource.Resource) -> a
    int getEAllContentsSize(org.eclipse.emf.ecore.resource.Resource) -> b
    java.lang.String getModelRelativeName(org.eclipse.emf.ecore.EClassifier) -> a
    org.eclipse.emf.ecore.EPackage getRootPackage(org.eclipse.emf.ecore.EClassifier) -> b
    java.lang.String getEObjectID(org.eclipse.emf.ecore.EObject) -> c
    java.lang.String getEObjectURI(org.eclipse.emf.ecore.EObject) -> d
    java.lang.Object getEObjectsAttribute(org.eclipse.emf.ecore.EObject,java.lang.String) -> b
    java.util.List getAttributesByRegEx(org.eclipse.emf.ecore.EClass,java.lang.String,boolean) -> a
org.sidiff.common.emf.EObjectStringResolver -> org.sidiff.common.emf.a:
    java.lang.String resolve(java.lang.Object) -> a
    java.lang.Class dedicatedClass() -> a
org.sidiff.common.emf.ElementByIDMap -> org.sidiff.common.emf.e:
org.sidiff.common.emf.UnknownAttributeException -> org.sidiff.common.emf.f:
org.sidiff.common.emf.UnknownDocumentTypeException -> org.sidiff.common.emf.h:
org.sidiff.common.emf.access.EMFMetaAccess -> org.sidiff.common.emf.access.c:
    java.lang.String PACKAGE_DELIMITER_CHAR -> a
    java.lang.String PACKAGE_DELIMITER_CHAR_REGEX -> b
    org.eclipse.emf.ecore.EClassifier getMetaObjectByName(java.lang.String,java.lang.String) -> a
    org.eclipse.emf.ecore.EPackage getSubpackageByName(java.lang.String,java.lang.String) -> c
    org.eclipse.emf.ecore.EPackage getSubpackageByName(org.eclipse.emf.ecore.EPackage,java.lang.String) -> a
    org.eclipse.emf.common.util.EList getMetaClassesForPackage(java.lang.String) -> a
    org.eclipse.emf.common.util.EList getMetaClassesForPackage(java.lang.String,java.lang.String) -> b
    org.eclipse.emf.common.util.EList getAllMetaClassesForPackage(java.lang.String) -> b
    org.eclipse.emf.common.util.EList getAllMetaClassesForPackage(org.eclipse.emf.ecore.EPackage) -> a
    java.util.List getMetaObjectListByString(java.lang.String,java.lang.String,java.lang.Class) -> a
    org.eclipse.emf.ecore.EReference getMetaReferenceByName(java.lang.String,java.lang.String,java.lang.String) -> a
    java.util.List getReferences(org.eclipse.emf.ecore.EClass) -> a
    java.util.List getReferences(org.eclipse.emf.ecore.EClass,org.sidiff.common.emf.access.EdgeSemantic) -> a
    java.util.List getChildrenReferences(org.eclipse.emf.ecore.EClass) -> b
    java.util.List getReferencesByNames(org.eclipse.emf.ecore.EClass,java.lang.String) -> a
    java.util.List getAttributesByRegEx(org.eclipse.emf.ecore.EClass,java.lang.String,boolean) -> a
    org.sidiff.common.emf.access.EMFPath translatePath(org.eclipse.emf.ecore.EClass,java.lang.String) -> b
    java.util.List getSubclasses(org.eclipse.emf.ecore.EClass,org.eclipse.emf.ecore.EPackage[]) -> a
    java.util.List getAllSubclasses(org.eclipse.emf.ecore.EClass,org.eclipse.emf.ecore.EPackage[]) -> b
    java.util.List getSubclasses(org.eclipse.emf.ecore.EClass,org.eclipse.emf.ecore.EPackage[],boolean) -> a
    java.util.List getContainerClasses(org.eclipse.emf.ecore.EClassifier) -> a
    java.util.List getChildrenClasses(org.eclipse.emf.ecore.EClass) -> c
org.sidiff.common.emf.access.EMFModelAccess -> org.sidiff.common.emf.access.d:
    org.sidiff.common.emf.access.EMFModelAccessor modelAccessor -> a
    org.sidiff.common.emf.access.EMFPathAccessor pathAccessor -> b
    org.sidiff.common.emf.access.EMFReverseAccessor reverseAccessor -> c
    int getIndexOf(org.eclipse.emf.ecore.EObject) -> a
    int getNumberOfSiblings(org.eclipse.emf.ecore.EObject) -> b
    java.lang.String getDocumentType(org.eclipse.emf.ecore.EObject) -> c
    java.lang.String getDocumentType(org.eclipse.emf.ecore.resource.Resource) -> a
    java.util.List getChildren(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EReference) -> a
    java.util.List getChildren(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EClass) -> a
    java.util.List getChildrenTypes(org.eclipse.emf.ecore.EObject) -> d
    boolean isTree(org.eclipse.emf.ecore.EObject) -> e
    boolean isTree(org.eclipse.emf.ecore.resource.Resource) -> b
    org.eclipse.emf.ecore.EObject getTreeRoot(org.eclipse.emf.ecore.EObject) -> f
    void traverse(org.eclipse.emf.ecore.EObject,org.sidiff.common.emf.access.tree.TreeVisitor) -> a
    java.util.List getReferencedObjects(org.eclipse.emf.ecore.EObject) -> g
    java.util.List getReferencedObjects(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EClass) -> b
    java.util.List getReferencedObjects(org.eclipse.emf.ecore.EObject,org.sidiff.common.emf.access.EdgeSemantic) -> a
    java.util.List getReferencedObjects(org.eclipse.emf.ecore.EObject,org.sidiff.common.emf.access.EdgeSemantic,org.eclipse.emf.ecore.EClass) -> a
    java.util.List getSiblings(org.eclipse.emf.ecore.EObject) -> h
    org.eclipse.emf.ecore.EObject getLeftSibling(org.eclipse.emf.ecore.EObject) -> i
    org.eclipse.emf.ecore.EObject getRightSibling(org.eclipse.emf.ecore.EObject) -> j
    java.util.List getNodeNeighbors(org.eclipse.emf.ecore.EObject) -> k
    java.util.List getNodeNeighbors(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EReference[]) -> a
    java.util.List getNodeNeighbors(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EClass[]) -> a
    java.util.List getNodeNeighbors(org.eclipse.emf.ecore.EObject,org.sidiff.common.emf.access.EdgeSemantic) -> b
    java.util.List getNodeNeighbors(org.eclipse.emf.ecore.EObject,org.sidiff.common.emf.access.EdgeSemantic,org.eclipse.emf.ecore.EClass[]) -> a
    java.util.Collection getTargetElements(org.eclipse.emf.ecore.EObject,org.sidiff.common.emf.access.EMFPath) -> a
    java.util.Collection getAllElements(org.eclipse.emf.ecore.EObject,org.sidiff.common.emf.access.EMFPath) -> b
    java.util.Collection getAllElementByPath(org.eclipse.emf.ecore.EObject,org.sidiff.common.emf.access.EMFPath) -> c
    java.util.List getAllElementByStep(org.eclipse.emf.ecore.EObject,org.sidiff.common.emf.access.EMFPath) -> d
    java.lang.Object getRemoteAttributeValue(org.eclipse.emf.ecore.EObject,org.sidiff.common.emf.access.EMFPath,org.eclipse.emf.ecore.EAttribute) -> a
    java.util.Collection getRefers(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EReference) -> b
org.sidiff.common.emf.access.EMFModelAccessor -> org.sidiff.common.emf.access.EMFModelAccessor:
    java.util.List getChildren(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EReference) -> a
    java.util.List getChildren(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EClass) -> a
    java.util.List getChildrenTypes(org.eclipse.emf.ecore.EObject) -> b
    boolean isTree(org.eclipse.emf.ecore.EObject) -> i
    boolean isTree(org.eclipse.emf.ecore.resource.Resource) -> b
    void traverse(org.eclipse.emf.ecore.EObject,org.sidiff.common.emf.access.tree.TreeVisitor) -> a
    org.eclipse.emf.ecore.EObject getTreeRoot(org.eclipse.emf.ecore.EObject) -> h
    java.util.List getReferencedObjects(org.eclipse.emf.ecore.EObject) -> e
    java.util.List getReferencedObjects(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EClass) -> b
    java.util.List getReferencedObjects(org.eclipse.emf.ecore.EObject,org.sidiff.common.emf.access.EdgeSemantic) -> b
    java.util.List getReferencedObjects(org.eclipse.emf.ecore.EObject,org.sidiff.common.emf.access.EdgeSemantic,org.eclipse.emf.ecore.EClass) -> a
    java.util.List getSiblings(org.eclipse.emf.ecore.EObject) -> g
    org.eclipse.emf.ecore.EObject getLeftSibling(org.eclipse.emf.ecore.EObject) -> d
    org.eclipse.emf.ecore.EObject getRightSibling(org.eclipse.emf.ecore.EObject) -> f
    java.lang.String getDocumentType(org.eclipse.emf.ecore.EObject) -> c
    java.lang.String getDocumentType(org.eclipse.emf.ecore.resource.Resource) -> a
    java.util.List getNodeNeighbors(org.eclipse.emf.ecore.EObject) -> a
    java.util.List getNodeNeighbors(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EReference[]) -> a
    java.util.List getNodeNeighbors(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EClass[]) -> a
    java.util.List getNodeNeighbors(org.eclipse.emf.ecore.EObject,org.sidiff.common.emf.access.EdgeSemantic) -> a
    java.util.List getNodeNeighbors(org.eclipse.emf.ecore.EObject,org.sidiff.common.emf.access.EdgeSemantic,org.eclipse.emf.ecore.EClass[]) -> a
org.sidiff.common.emf.access.EMFPath -> org.sidiff.common.emf.access.EMFPath:
    void enableBackstepping(boolean) -> a
org.sidiff.common.emf.access.EMFPathAccessor -> org.sidiff.common.emf.access.EMFPathAccessor:
    java.util.Collection getTargetElements(org.eclipse.emf.ecore.EObject,org.sidiff.common.emf.access.EMFPath) -> a
    java.util.Collection getAllElements(org.eclipse.emf.ecore.EObject,org.sidiff.common.emf.access.EMFPath) -> b
    java.util.Collection getAllElementByPath(org.eclipse.emf.ecore.EObject,org.sidiff.common.emf.access.EMFPath) -> c
    java.util.List getAllElementByStep(org.eclipse.emf.ecore.EObject,org.sidiff.common.emf.access.EMFPath) -> d
    org.sidiff.common.emf.access.EMFPath translatePath(org.eclipse.emf.ecore.EClass,java.lang.String) -> a
org.sidiff.common.emf.access.EMFReverseAccessor -> org.sidiff.common.emf.access.EMFReverseAccessor:
    java.util.Collection getRefers(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EReference) -> a
org.sidiff.common.emf.access.EdgeSemantic -> org.sidiff.common.emf.access.a:
    org.sidiff.common.emf.access.EdgeSemantic Submodel -> a
    org.sidiff.common.emf.access.EdgeSemantic Nesting -> b
    org.sidiff.common.emf.access.EdgeSemantic Reference -> c
    org.sidiff.common.emf.access.EdgeSemantic Incoming -> d
    org.sidiff.common.emf.access.EdgeSemantic Outgoing -> e
    org.sidiff.common.emf.access.EdgeSemantic Parent -> f
    int mode -> g
    org.sidiff.common.emf.access.EdgeSemantic[] ENUM$VALUES -> h
    boolean checkSemantic(org.eclipse.emf.ecore.EReference) -> a
    org.sidiff.common.emf.access.EdgeSemantic[] values() -> values
    org.sidiff.common.emf.access.EdgeSemantic valueOf(java.lang.String) -> valueOf
org.sidiff.common.emf.access.ExternalObjectComparison -> org.sidiff.common.emf.access.b:
    org.sidiff.common.emf.access.ExternalObjectComparison Equal -> a
    org.sidiff.common.emf.access.ExternalObjectComparison Different -> b
    org.sidiff.common.emf.access.ExternalObjectComparison BothInternal -> c
    boolean $assertionsDisabled -> d
    org.sidiff.common.emf.access.ExternalObjectComparison[] ENUM$VALUES -> e
    org.sidiff.common.emf.access.ExternalObjectComparison compare(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.resource.Resource[]) -> a
    org.eclipse.emf.ecore.EObject findEqualObject(org.eclipse.emf.ecore.EObject,java.util.Collection,org.eclipse.emf.ecore.resource.Resource) -> a
    org.sidiff.common.emf.access.ExternalObjectComparison[] values() -> values
    org.sidiff.common.emf.access.ExternalObjectComparison valueOf(java.lang.String) -> valueOf
org.sidiff.common.emf.access.context.Context -> org.sidiff.common.emf.access.context.a:
    org.eclipse.emf.ecore.EObject element -> a
    java.lang.String contextName -> b
    boolean isOrdered -> c
    java.util.List contextElements -> d
    org.eclipse.emf.ecore.EObject getElement() -> a
    void setElement(org.eclipse.emf.ecore.EObject) -> a
    java.lang.String getContextName() -> b
    void setContextName(java.lang.String) -> a
    boolean isOrdered() -> c
    void setOrdered(boolean) -> a
    java.util.List getContextElements() -> d
    void addToContextElements(org.eclipse.emf.ecore.EObject) -> b
    void addToContextElements(java.util.Collection) -> a
    int getSize() -> e
org.sidiff.common.emf.access.context.ContextConfigurationHandler -> org.sidiff.common.emf.access.context.e:
    java.lang.String ELEM_SETTINGS -> a
    java.lang.String ATT_SETTINGS_DOCTYPE -> b
    java.lang.String ELEM_CLASS -> c
    java.lang.String ELEM_CLASS_NAME -> d
    java.lang.String ELEM_CONTEXT -> e
    java.lang.String ATT_CONTEXT_NAME -> f
    java.lang.String ATT_CONTEXT_IS_ORDERED -> g
    java.lang.String ELEM_PATH -> h
    java.lang.String ATT_PATH_VALUE -> i
    java.lang.String GROUPED_CONTEXT -> j
    java.lang.String GROUP -> k
    java.lang.String GROUP_PATH -> l
    java.util.HashMap createMap(org.w3c.dom.Document) -> a
    java.lang.String getDocumentType(org.w3c.dom.Document) -> b
org.sidiff.common.emf.access.context.ContextConfigurationObject -> org.sidiff.common.emf.access.context.b:
    java.lang.String name -> a
    boolean isOrdered -> b
    java.util.ArrayList pathList -> c
    java.lang.String getName() -> a
    boolean isOrdered() -> b
    java.util.ArrayList getPathList() -> c
org.sidiff.common.emf.access.context.ContextSelector -> org.sidiff.common.emf.access.context.d:
    java.lang.String SIBLINGS -> a
    java.lang.String LSIBLING -> b
    java.lang.String RSIBLING -> c
    java.lang.String CHILDREN -> d
    java.lang.String NEIGHBORS -> e
    java.lang.String INCOMING_NEIGHBORS -> f
    java.lang.String OUTGOING_NEIGHBORS -> g
    java.lang.String CLASSES -> h
    java.lang.String docType -> i
    java.util.HashMap config -> j
    void loadConfiguration(org.w3c.dom.Document) -> a
    java.util.Map selectContext(org.eclipse.emf.ecore.EObject) -> a
    org.sidiff.common.emf.access.context.Context selectContextByName(org.eclipse.emf.ecore.EObject,java.lang.String) -> a
    java.util.List caseNormalPath(java.lang.String,org.sidiff.common.emf.access.context.ContextConfigurationObject,org.eclipse.emf.ecore.EObject) -> a
    java.util.List caseAllElementsPath(java.lang.String,org.sidiff.common.emf.access.context.ContextConfigurationObject,org.eclipse.emf.ecore.EObject) -> b
    java.util.List caseByStepElementsPath(java.lang.String,org.sidiff.common.emf.access.context.ContextConfigurationObject,org.eclipse.emf.ecore.EObject) -> c
    java.util.Collection caseByPathElementsPath(java.lang.String,org.sidiff.common.emf.access.context.ContextConfigurationObject,org.eclipse.emf.ecore.EObject) -> d
    java.util.List caseParameter(java.lang.String,org.sidiff.common.emf.access.context.ContextConfigurationObject,org.eclipse.emf.ecore.EObject) -> e
    java.util.List caseSingleParameter(java.lang.String,org.sidiff.common.emf.access.context.ContextConfigurationObject,org.eclipse.emf.ecore.EObject) -> f
    java.util.List caseTwoParameter(java.lang.String[],org.sidiff.common.emf.access.context.ContextConfigurationObject,org.eclipse.emf.ecore.EObject) -> a
    java.util.List caseMoreParameter(java.lang.String[],org.sidiff.common.emf.access.context.ContextConfigurationObject,org.eclipse.emf.ecore.EObject) -> b
    boolean hasContext(org.eclipse.emf.ecore.EClass,java.lang.String) -> a
org.sidiff.common.emf.access.context.GroupContext -> org.sidiff.common.emf.access.context.c:
    java.util.List groupContextElements -> a
    void setGroupContextElements(java.util.List) -> a
    java.util.List getGroupContextElements() -> f
    void addToGroupContextElements(java.util.ArrayList) -> a
org.sidiff.common.emf.access.context.GroupContextConfigurationObject -> org.sidiff.common.emf.access.context.f:
    java.util.ArrayList group -> d
    java.util.ArrayList getGroup() -> d
    void setGroup(java.util.ArrayList) -> a
org.sidiff.common.emf.access.impl.EMFIndexedAccessorImpl -> org.sidiff.common.emf.access.impl.d:
    java.util.Map index -> b
    boolean $assertionsDisabled -> a
    java.util.Collection getRefers(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EReference) -> a
    void createIndex(org.eclipse.emf.ecore.resource.Resource) -> a
    void addIndexEntry(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EReference,org.eclipse.emf.ecore.EObject,java.util.Map) -> a
org.sidiff.common.emf.access.impl.EMFModelAccessorImpl -> org.sidiff.common.emf.access.impl.a:
    java.util.List getNodeNeighbors(org.eclipse.emf.ecore.EObject) -> a
    java.util.List getNodeNeighbors(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EReference[]) -> a
    java.util.List getNodeNeighbors(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EClass[]) -> a
    java.util.List getNodeNeighbors(org.eclipse.emf.ecore.EObject,org.sidiff.common.emf.access.EdgeSemantic) -> a
    java.util.List getNodeNeighbors(org.eclipse.emf.ecore.EObject,org.sidiff.common.emf.access.EdgeSemantic,org.eclipse.emf.ecore.EClass[]) -> a
    java.util.List getChildren(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EReference) -> a
    java.util.List getChildren(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EClass) -> a
    java.util.List getChildrenTypes(org.eclipse.emf.ecore.EObject) -> b
    java.lang.String getDocumentType(org.eclipse.emf.ecore.EObject) -> c
    java.lang.String getDocumentType(org.eclipse.emf.ecore.resource.Resource) -> a
    org.eclipse.emf.ecore.EObject getLeftSibling(org.eclipse.emf.ecore.EObject) -> d
    java.util.List getReferencedObjects(org.eclipse.emf.ecore.EObject) -> e
    java.util.List getReferencedObjects(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EClass) -> b
    java.util.List getReferencedObjects(org.eclipse.emf.ecore.EObject,org.sidiff.common.emf.access.EdgeSemantic) -> b
    java.util.List getReferencedObjects(org.eclipse.emf.ecore.EObject,org.sidiff.common.emf.access.EdgeSemantic,org.eclipse.emf.ecore.EClass) -> a
    org.eclipse.emf.ecore.EObject getRightSibling(org.eclipse.emf.ecore.EObject) -> f
    java.util.List getSiblings(org.eclipse.emf.ecore.EObject) -> g
    org.eclipse.emf.ecore.EObject getTreeRoot(org.eclipse.emf.ecore.EObject) -> h
    boolean isTree(org.eclipse.emf.ecore.EObject) -> i
    boolean isTree(org.eclipse.emf.ecore.resource.Resource) -> b
    void traverse(org.eclipse.emf.ecore.EObject,org.sidiff.common.emf.access.tree.TreeVisitor) -> a
    void traverse(org.eclipse.emf.ecore.EObject,java.util.HashSet,org.sidiff.common.emf.access.tree.TreeVisitor) -> a
org.sidiff.common.emf.access.impl.EMFPathAccessorImpl -> org.sidiff.common.emf.access.impl.c:
    boolean $assertionsDisabled -> a
    java.util.Collection getTargetElements(org.eclipse.emf.ecore.EObject,org.sidiff.common.emf.access.EMFPath) -> a
    java.util.Collection getAllElements(org.eclipse.emf.ecore.EObject,org.sidiff.common.emf.access.EMFPath) -> b
    java.util.List getAllElementByStep(org.eclipse.emf.ecore.EObject,org.sidiff.common.emf.access.EMFPath) -> d
    java.util.Collection getAllElementByPath(org.eclipse.emf.ecore.EObject,org.sidiff.common.emf.access.EMFPath) -> c
    org.sidiff.common.emf.access.EMFPath translatePath(org.eclipse.emf.ecore.EClass,java.lang.String) -> a
    java.util.Collection getTargetElements(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EReference[],boolean,java.util.Collection,java.util.List) -> a
    java.util.Collection computeStep(java.util.Collection,org.eclipse.emf.ecore.EReference,java.util.Collection) -> a
org.sidiff.common.emf.access.impl.EMFPathImpl -> org.sidiff.common.emf.access.impl.b:
    org.eclipse.emf.ecore.EReference[] refs -> a
    boolean backstepping -> b
    boolean $assertionsDisabled -> c
    void enableBackstepping(boolean) -> a
org.sidiff.common.emf.access.path.CollectorAccessStrategy -> org.sidiff.common.emf.access.path.CollectorAccessStrategy:
org.sidiff.common.emf.access.path.EMFPath -> org.sidiff.common.emf.access.path.EMFPath:
org.sidiff.common.emf.access.path.EMFPathAccessor -> org.sidiff.common.emf.access.path.EMFPathAccessor:
    org.sidiff.common.emf.access.path.EMFPath translatePath(org.eclipse.emf.ecore.EClass,java.lang.String) -> a
    java.util.Collection evaluatePath(org.eclipse.emf.ecore.EObject,org.sidiff.common.emf.access.path.EMFPath,org.sidiff.common.emf.access.path.PathEvaluationStrategy) -> a
    org.sidiff.common.emf.access.path.PathEvaluationStrategy getStrategy(java.lang.Class) -> a
org.sidiff.common.emf.access.path.PathEvaluationStrategy -> org.sidiff.common.emf.access.path.PathEvaluationStrategy:
org.sidiff.common.emf.access.path.PathsAccessStrategy -> org.sidiff.common.emf.access.path.PathsAccessStrategy:
org.sidiff.common.emf.access.path.SliceAccessStrategy -> org.sidiff.common.emf.access.path.SliceAccessStrategy:
org.sidiff.common.emf.access.path.TargetEvaluationStrategy -> org.sidiff.common.emf.access.path.TargetEvaluationStrategy:
org.sidiff.common.emf.access.path.axis.Ancestor -> org.sidiff.common.emf.access.path.axis.f:
    java.util.Collection evaluateAxis(java.util.Collection) -> a
    void initAxis(org.sidiff.common.emf.access.path.impl.EMFPathStepImpl) -> a
    org.eclipse.emf.ecore.EClass resultType() -> a
org.sidiff.common.emf.access.path.axis.Children -> org.sidiff.common.emf.access.path.axis.a:
    java.util.Collection evaluateAxis(java.util.Collection) -> a
    void initAxis(org.sidiff.common.emf.access.path.impl.EMFPathStepImpl) -> a
    org.eclipse.emf.ecore.EClass resultType() -> a
org.sidiff.common.emf.access.path.axis.Descendant -> org.sidiff.common.emf.access.path.axis.d:
    java.util.Collection evaluateAxis(java.util.Collection) -> a
    void initAxis(org.sidiff.common.emf.access.path.impl.EMFPathStepImpl) -> a
    org.eclipse.emf.ecore.EClass resultType() -> a
org.sidiff.common.emf.access.path.axis.EMFAxis -> org.sidiff.common.emf.access.path.axis.e:
    java.lang.String argumentString -> b
    void initAxis(org.sidiff.common.emf.access.path.impl.EMFPathStepImpl) -> a
    org.eclipse.emf.ecore.EClass resultType() -> a
    java.util.Collection evaluateAxis(java.util.Collection) -> a
org.sidiff.common.emf.access.path.axis.IncommingReference -> org.sidiff.common.emf.access.path.axis.b:
    org.eclipse.emf.ecore.EReference fromReference -> c
    boolean $assertionsDisabled -> a
    void initAxis(org.sidiff.common.emf.access.path.impl.EMFPathStepImpl) -> a
    java.util.Collection evaluateAxis(java.util.Collection) -> a
    org.eclipse.emf.ecore.EClass resultType() -> a
org.sidiff.common.emf.access.path.axis.OutgoingReference -> org.sidiff.common.emf.access.path.axis.c:
    org.eclipse.emf.ecore.EReference toReference -> c
    boolean $assertionsDisabled -> a
    void initAxis(org.sidiff.common.emf.access.path.impl.EMFPathStepImpl) -> a
    java.util.Collection evaluateAxis(java.util.Collection) -> a
    org.eclipse.emf.ecore.EClass resultType() -> a
org.sidiff.common.emf.access.path.axis.Parent -> org.sidiff.common.emf.access.path.axis.h:
    java.util.Collection evaluateAxis(java.util.Collection) -> a
    void initAxis(org.sidiff.common.emf.access.path.impl.EMFPathStepImpl) -> a
    org.eclipse.emf.ecore.EClass resultType() -> a
org.sidiff.common.emf.access.path.axis.Roots -> org.sidiff.common.emf.access.path.axis.i:
    java.util.Collection evaluateAxis(java.util.Collection) -> a
    void initAxis(org.sidiff.common.emf.access.path.impl.EMFPathStepImpl) -> a
    org.eclipse.emf.ecore.EClass resultType() -> a
org.sidiff.common.emf.access.path.axis.Siblings -> org.sidiff.common.emf.access.path.axis.g:
    java.util.Collection evaluateAxis(java.util.Collection) -> a
    void initAxis(org.sidiff.common.emf.access.path.impl.EMFPathStepImpl) -> a
    org.eclipse.emf.ecore.EClass resultType() -> a
org.sidiff.common.emf.access.path.conditions.AND -> org.sidiff.common.emf.access.path.conditions.a:
    void initCondition(org.sidiff.common.emf.access.path.impl.EMFPathStepImpl) -> a
    boolean select(org.eclipse.emf.ecore.EObject) -> a
org.sidiff.common.emf.access.path.conditions.EMFCondition -> org.sidiff.common.emf.access.path.conditions.e:
    java.lang.String argumentString -> a
    void initCondition(org.sidiff.common.emf.access.path.impl.EMFPathStepImpl) -> a
    boolean select(org.eclipse.emf.ecore.EObject) -> a
    boolean select(java.lang.Object) -> a
org.sidiff.common.emf.access.path.conditions.Equal -> org.sidiff.common.emf.access.path.conditions.b:
    void initCondition(org.sidiff.common.emf.access.path.impl.EMFPathStepImpl) -> a
    boolean select(org.eclipse.emf.ecore.EObject) -> a
org.sidiff.common.emf.access.path.conditions.NoBackstep -> org.sidiff.common.emf.access.path.conditions.d:
    org.sidiff.common.emf.access.path.impl.EMFPathStepImpl lastStep -> b
    void initCondition(org.sidiff.common.emf.access.path.impl.EMFPathStepImpl) -> a
    boolean select(org.eclipse.emf.ecore.EObject) -> a
org.sidiff.common.emf.access.path.conditions.NoCycle -> org.sidiff.common.emf.access.path.conditions.f:
    java.util.Collection possibleCyclesOnPath -> b
    void initCondition(org.sidiff.common.emf.access.path.impl.EMFPathStepImpl) -> a
    boolean select(org.eclipse.emf.ecore.EObject) -> a
org.sidiff.common.emf.access.path.conditions.OR -> org.sidiff.common.emf.access.path.conditions.c:
    void initCondition(org.sidiff.common.emf.access.path.impl.EMFPathStepImpl) -> a
    boolean select(org.eclipse.emf.ecore.EObject) -> a
org.sidiff.common.emf.access.path.impl.EMFPathAccessorImpl -> org.sidiff.common.emf.access.path.impl.EMFPathAccessorImpl:
    java.lang.String TYPE_WILDCAT -> b
    java.lang.String NS_TYPENAME_SEPERATOR -> c
    java.lang.String AXIX_ARGUMENT_SEPERATOR -> d
    java.lang.String PATH_STEP_SEPERATOR -> e
    java.lang.String STEP_AXIS_SEPERATOR -> f
    java.lang.String CONDITION_START_CHARACTER -> g
    java.lang.String CONDITION_END_CHARACTER -> h
    java.lang.String AXIS_PREFIX -> i
    java.lang.String CONDITION_PREFIX -> j
    java.util.Map namespaces -> k
    java.util.Map strategies -> l
    boolean $assertionsDisabled -> a
    java.util.Collection evaluatePath(org.eclipse.emf.ecore.EObject,org.sidiff.common.emf.access.path.EMFPath,org.sidiff.common.emf.access.path.PathEvaluationStrategy) -> a
    org.sidiff.common.emf.access.path.PathEvaluationStrategy getStrategy(java.lang.Class) -> a
    org.sidiff.common.emf.access.path.EMFPath translatePath(org.eclipse.emf.ecore.EClass,java.lang.String) -> a
    org.sidiff.common.emf.access.path.impl.EMFPathStepImpl createStep(java.lang.String,org.eclipse.emf.ecore.EClass) -> a
    org.sidiff.common.emf.access.path.axis.EMFAxis createAxis(java.lang.String) -> a
    org.sidiff.common.emf.access.path.conditions.EMFCondition createCondition(java.lang.String) -> b
    org.eclipse.emf.ecore.EClass getClassByString(org.eclipse.emf.ecore.EClass,java.lang.String) -> b
    org.eclipse.emf.ecore.EClass lookupClass(org.eclipse.emf.ecore.EPackage,java.lang.String) -> a
    org.eclipse.emf.ecore.EClass lookupClass(org.eclipse.emf.ecore.resource.Resource,java.lang.String) -> a
    org.eclipse.emf.ecore.EClass lookupClass(java.lang.String,java.lang.String) -> a
    void registerNSName(java.lang.String,org.eclipse.emf.ecore.EPackage) -> a
org.sidiff.common.emf.access.path.impl.EMFPathAccessorImpl$EClassLookupException -> org.sidiff.common.emf.access.path.impl.e:
    long serialVersionUID -> a
org.sidiff.common.emf.access.path.impl.EMFPathAccessorImpl$StrategyImpl -> org.sidiff.common.emf.access.path.impl.EMFPathAccessorImpl$StrategyImpl:
    java.util.Collection evaluate(org.eclipse.emf.ecore.EObject,org.sidiff.common.emf.access.path.EMFPath) -> a
org.sidiff.common.emf.access.path.impl.EMFPathImpl -> org.sidiff.common.emf.access.path.impl.a:
    org.sidiff.common.emf.access.path.impl.EMFPathStepImpl fistStep -> b
    org.sidiff.common.emf.access.path.impl.EMFPathStepImpl lastStep -> c
    boolean $assertionsDisabled -> a
    org.sidiff.common.emf.access.path.impl.EMFPathImpl initPath(org.eclipse.emf.ecore.EClass) -> a
    void addStep(org.sidiff.common.emf.access.path.impl.EMFPathStepImpl) -> a
    java.util.Iterator iterator() -> iterator
org.sidiff.common.emf.access.path.impl.EMFPathImpl$EMFPathStepIterator -> org.sidiff.common.emf.access.path.impl.d:
    org.sidiff.common.emf.access.path.impl.EMFPathStepImpl currentStep -> a
    boolean hasNext() -> hasNext
    org.sidiff.common.emf.access.path.impl.EMFPathStepImpl next() -> a
    void remove() -> remove
    java.lang.Object next() -> next
org.sidiff.common.emf.access.path.impl.EMFPathStepImpl -> org.sidiff.common.emf.access.path.impl.c:
    org.sidiff.common.emf.access.path.impl.EMFPathStepImpl nextStep -> a
    org.sidiff.common.emf.access.path.impl.EMFPathStepImpl ancestorStep -> b
    org.sidiff.common.emf.access.path.impl.EMFPathImpl path -> c
    org.sidiff.common.emf.access.path.axis.EMFAxis axis -> d
    org.eclipse.emf.ecore.EClass nodeTypeCondition -> e
    org.sidiff.common.emf.access.path.conditions.EMFCondition nodePropertyCondition -> f
    org.eclipse.emf.ecore.EClass pathStepContext -> g
    java.util.Collection lastResult -> h
    void initPathStep(org.eclipse.emf.ecore.EClass) -> a
    java.util.Collection evaluateStep(java.util.Collection) -> a
    java.util.Collection result() -> a
    org.eclipse.emf.ecore.EClass resultType() -> b
    org.eclipse.emf.ecore.EClass contextType() -> c
    org.sidiff.common.emf.access.path.impl.EMFPathStepImpl getNextStep() -> d
    org.sidiff.common.emf.access.path.impl.EMFPathStepImpl getAncestorStep() -> e
org.sidiff.common.emf.access.path.impl.TargetEvaluationStrategyImpl -> org.sidiff.common.emf.access.path.impl.b:
    java.util.Collection evaluate(org.eclipse.emf.ecore.EObject,org.sidiff.common.emf.access.path.EMFPath) -> a
org.sidiff.common.emf.access.tree.CompositeTreeVisitor -> org.sidiff.common.emf.access.tree.c:
    java.util.List visitors -> a
    void addVisitor(org.sidiff.common.emf.access.tree.TreeVisitor) -> a
    boolean preExecute(org.eclipse.emf.ecore.EObject) -> d
    void postExecute(org.eclipse.emf.ecore.EObject) -> c
    void init(org.eclipse.emf.ecore.EObject) -> b
    void finish(org.eclipse.emf.ecore.EObject) -> a
org.sidiff.common.emf.access.tree.NoNestingEdgeException -> org.sidiff.common.emf.access.tree.d:
org.sidiff.common.emf.access.tree.NoOrderedContainmentException -> org.sidiff.common.emf.access.tree.b:
org.sidiff.common.emf.access.tree.NoTreeException -> org.sidiff.common.emf.access.tree.e:
org.sidiff.common.emf.access.tree.NoValidTreeException -> org.sidiff.common.emf.access.tree.a:
org.sidiff.common.emf.access.tree.TreeVisitor -> org.sidiff.common.emf.access.tree.TreeVisitor:
    boolean preExecute(org.eclipse.emf.ecore.EObject) -> d
    void postExecute(org.eclipse.emf.ecore.EObject) -> c
    void init(org.eclipse.emf.ecore.EObject) -> b
    void finish(org.eclipse.emf.ecore.EObject) -> a
org.sidiff.common.emf.access.tree.TreeVisitorImpl -> org.sidiff.common.emf.access.tree.f:
    void postExecute(org.eclipse.emf.ecore.EObject) -> c
    boolean preExecute(org.eclipse.emf.ecore.EObject) -> d
    void finish(org.eclipse.emf.ecore.EObject) -> a
    void init(org.eclipse.emf.ecore.EObject) -> b
org.sidiff.common.emf.adapters.EObjectAdapter -> org.sidiff.common.emf.adapters.EObjectAdapter:
    org.eclipse.emf.ecore.EObject getEObject() -> a
    void setAdapterFactory(org.sidiff.common.emf.adapters.EObjectAdapterFactory) -> a
    org.eclipse.emf.common.notify.Adapter adapt(org.eclipse.emf.ecore.EObject) -> a
org.sidiff.common.emf.adapters.EObjectAdapterFactory -> org.sidiff.common.emf.adapters.a:
    java.lang.Object adapterType -> a
    java.lang.Object getAdapterType() -> a
    boolean isFactoryForType(java.lang.Object) -> isFactoryForType
    org.eclipse.emf.common.notify.Adapter createAdapter(org.eclipse.emf.common.notify.Notifier) -> createAdapter
    org.sidiff.common.emf.adapters.EObjectAdapter createAdapter() -> b
org.sidiff.common.emf.adapters.EObjectAdapterImpl -> org.sidiff.common.emf.adapters.b:
    org.eclipse.emf.ecore.EObject object -> a
    org.sidiff.common.emf.adapters.EObjectAdapterFactory adapterFactory -> b
    void setAdapterFactory(org.sidiff.common.emf.adapters.EObjectAdapterFactory) -> a
    void setTarget(org.eclipse.emf.common.notify.Notifier) -> setTarget
    org.eclipse.emf.ecore.EObject getEObject() -> a
    boolean isAdapterForType(java.lang.Object) -> isAdapterForType
    org.eclipse.emf.common.notify.Adapter adapt(org.eclipse.emf.ecore.EObject) -> a
org.sidiff.common.emf.annotation.AnnotateableElement -> org.sidiff.common.emf.annotation.AnnotateableElement:
    void setAnnotation(java.lang.String,java.lang.Object) -> a
    java.lang.Object getAnnotation(java.lang.String,java.lang.Class) -> a
    java.lang.Object getOrCreateAnnotation(java.lang.String,java.lang.Class) -> b
    boolean hasAnnotation(java.lang.String) -> a
    void removeAnnotation(java.lang.String) -> b
    java.util.Collection getAnnotations() -> b
org.sidiff.common.emf.annotation.AnnotationDebugger -> org.sidiff.common.emf.annotation.c:
    java.lang.String annotations(org.eclipse.emf.ecore.EObject) -> a
    java.lang.String annotation(org.eclipse.emf.ecore.EObject,java.lang.String) -> a
    java.lang.String annotations(org.eclipse.emf.ecore.resource.Resource) -> a
    java.lang.String annotations(org.eclipse.emf.ecore.resource.Resource,java.lang.String) -> a
org.sidiff.common.emf.annotation.AnnotationException -> org.sidiff.common.emf.annotation.b:
    long serialVersionUID -> a
org.sidiff.common.emf.annotation.AnnotationKeyList -> org.sidiff.common.emf.annotation.f:
org.sidiff.common.emf.annotation.AnnotationNotExistsException -> org.sidiff.common.emf.annotation.e:
    long serialVersionUID -> a
org.sidiff.common.emf.annotation.AnnotationPersistence -> org.sidiff.common.emf.annotation.a:
    void serialize(org.eclipse.emf.ecore.resource.Resource,java.lang.String) -> a
    void deserialize(org.eclipse.emf.ecore.resource.Resource,java.lang.String) -> b
    com.thoughtworks.xstream.XStream getXStream(org.eclipse.emf.ecore.resource.Resource) -> a
org.sidiff.common.emf.annotation.AnnotationsAdapterFactory -> org.sidiff.common.emf.annotation.d:
    org.sidiff.common.emf.adapters.EObjectAdapter createAdapter() -> b
org.sidiff.common.emf.annotation.internal.AnnotateableElementImpl -> org.sidiff.common.emf.annotation.internal.c:
    java.util.TreeMap annotations -> b
    java.lang.Object getAnnotation(java.lang.String,java.lang.Class) -> a
    boolean hasAnnotation(java.lang.String) -> a
    void removeAnnotation(java.lang.String) -> b
    void setAnnotation(java.lang.String,java.lang.Object) -> a
    java.lang.Object getOrCreateAnnotation(java.lang.String,java.lang.Class) -> b
    java.util.Collection getAnnotations() -> b
org.sidiff.common.emf.annotation.internal.EObjectConverter -> org.sidiff.common.emf.annotation.internal.e:
    org.eclipse.emf.ecore.resource.Resource resource -> a
    void marshal(java.lang.Object,com.thoughtworks.xstream.io.HierarchicalStreamWriter,com.thoughtworks.xstream.converters.MarshallingContext) -> marshal
    java.lang.Object unmarshal(com.thoughtworks.xstream.io.HierarchicalStreamReader,com.thoughtworks.xstream.converters.UnmarshallingContext) -> unmarshal
    boolean canConvert(java.lang.Class) -> canConvert
org.sidiff.common.emf.annotation.internal.MyAnnotatedElement -> org.sidiff.common.emf.annotation.internal.b:
    java.lang.String id -> a
    java.util.List list -> b
    void addAnnotation(org.sidiff.common.emf.annotation.internal.MyAnnotation) -> a
    java.util.List getAnnotations() -> a
    java.lang.String getID() -> b
org.sidiff.common.emf.annotation.internal.MyAnnotation -> org.sidiff.common.emf.annotation.internal.d:
    java.lang.String label -> a
    java.lang.Object value -> b
    java.lang.String getLabel() -> a
    java.lang.Object getValue() -> b
org.sidiff.common.emf.annotation.internal.MyAnnotations -> org.sidiff.common.emf.annotation.internal.a:
    java.lang.String resource -> a
    java.util.List list -> b
    void addElement(org.sidiff.common.emf.annotation.internal.MyAnnotatedElement) -> a
    java.util.List getElements() -> a
org.sidiff.common.emf.classifiers.EMFClassifiers -> org.sidiff.common.emf.classifiers.b:
    org.sidiff.common.collections.Classifier ELEMENT_BY_CLASS -> a
org.sidiff.common.emf.classifiers.EMFClassifiers$1 -> org.sidiff.common.emf.classifiers.a:
    org.eclipse.emf.ecore.EClass classify(org.eclipse.emf.ecore.EObject) -> a
    java.lang.Object classify(java.lang.Object) -> a
org.sidiff.common.emf.comparators.EMFComparators -> org.sidiff.common.emf.comparators.d:
    java.util.Comparator ATTRIBUTE_BY_NAME -> a
    java.util.Comparator REFERENCE_BY_NAME -> b
    java.util.Comparator createObjectByAnnotationComparator(java.lang.String) -> a
org.sidiff.common.emf.comparators.EMFComparators$1 -> org.sidiff.common.emf.comparators.c:
    int compare(org.eclipse.emf.ecore.EAttribute,org.eclipse.emf.ecore.EAttribute) -> a
    int compare(java.lang.Object,java.lang.Object) -> compare
org.sidiff.common.emf.comparators.EMFComparators$2 -> org.sidiff.common.emf.comparators.b:
    int compare(org.eclipse.emf.ecore.EReference,org.eclipse.emf.ecore.EReference) -> a
    int compare(java.lang.Object,java.lang.Object) -> compare
org.sidiff.common.emf.comparators.EMFComparators$3 -> org.sidiff.common.emf.comparators.a:
    java.lang.String val$annotationKey -> a
    int compare(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject) -> a
    int compare(java.lang.Object,java.lang.Object) -> compare
org.sidiff.common.emf.datatypes.ConceptualDataTypes -> org.sidiff.common.emf.datatypes.c:
    int FLOAT -> a
    int DOUBLE -> b
    int SHORT -> c
    int INTEGER -> d
    int LONG -> e
    int BIG_DECIMAL -> f
    int BIG_INTEGER -> g
    int STRING -> h
    int CHARACTER -> i
    int BOOLEAN -> j
    int DATE -> k
    int BYTE -> l
    int BYTE_ARRAY -> m
org.sidiff.common.emf.datatypes.DataTypeRegistry -> org.sidiff.common.emf.datatypes.a:
    java.lang.Object[][] TYPE_MAPPING -> a
org.sidiff.common.emf.datatypes.DataTypeRegistryAccess -> org.sidiff.common.emf.datatypes.b:
    org.sidiff.common.emf.datatypes.DataTypeRegistryAccessor registryAccessor -> a
    int getConceptualDataType(java.lang.Class) -> a
    int getConceptualDataType(org.eclipse.emf.ecore.EAttribute) -> a
    int getConceptualDataType(org.eclipse.emf.ecore.EDataType) -> a
    boolean isNumericType(org.eclipse.emf.ecore.EAttribute) -> b
    boolean isLetterType(org.eclipse.emf.ecore.EAttribute) -> c
org.sidiff.common.emf.datatypes.DataTypeRegistryAccessor -> org.sidiff.common.emf.datatypes.DataTypeRegistryAccessor:
    int getConceptualDataType(java.lang.Class) -> a
    int getConceptualDataType(org.eclipse.emf.ecore.EAttribute) -> a
    int getConceptualDataType(org.eclipse.emf.ecore.EDataType) -> a
    boolean isNumericType(org.eclipse.emf.ecore.EAttribute) -> b
    boolean isLetterType(org.eclipse.emf.ecore.EAttribute) -> c
org.sidiff.common.emf.datatypes.DataTypeRegistryAccessorImpl -> org.sidiff.common.emf.datatypes.d:
    java.util.Map ecoreMap -> a
    java.util.Map javaMap -> b
    int getConceptualDataType(java.lang.Class) -> a
    int getConceptualDataType(org.eclipse.emf.ecore.EAttribute) -> a
    int getConceptualDataType(org.eclipse.emf.ecore.EDataType) -> a
    boolean isNumericType(org.eclipse.emf.ecore.EAttribute) -> b
    boolean isLetterType(org.eclipse.emf.ecore.EAttribute) -> c
org.sidiff.common.emf.modelstorage.AbstractEMFImporter -> org.sidiff.common.emf.modelstorage.a:
    void parse(org.eclipse.emf.ecore.resource.Resource,java.io.InputStream) -> parse
    java.util.Set getMagicKeys() -> getMagicKeys
org.sidiff.common.emf.modelstorage.Loader -> org.sidiff.common.emf.modelstorage.Loader:
    void parse(org.eclipse.emf.ecore.resource.Resource,java.io.InputStream) -> parse
    java.util.Set getMagicKeys() -> getMagicKeys
    java.util.Map getSchemaLocationMappings() -> getSchemaLocationMappings
    java.lang.String getSuffix() -> getSuffix
    java.lang.String getLoaderDescription() -> getLoaderDescription
org.sidiff.common.emf.modelstorage.ModelStorage -> org.sidiff.common.emf.modelstorage.c:
    org.sidiff.common.emf.modelstorage.ModelStorage instance -> c
    java.lang.String URI_ID_SEPERATOR -> d
    char EXTENSION_SEPERATOR -> e
    java.lang.String EMF_MODEL_SUFFIX -> f
    java.lang.String NATIVE_MODEL_SUFFIX -> a
    java.lang.String TEMP_RESOURCE_PREFIX -> g
    int LOADERCHECK_READ_AHEAD -> h
    java.util.Map LOAD_OPTIONS -> i
    java.util.Map SAVE_OPTIONS -> j
    int internalModelID -> k
    org.eclipse.emf.ecore.resource.ResourceSet globalResourceSet -> l
    java.util.Map models -> m
    java.util.Map loadersByExtension -> n
    java.util.Map loadersByClass -> o
    boolean $assertionsDisabled -> b
    org.sidiff.common.emf.modelstorage.ModelStorage getInstance() -> a
    boolean registerLoader(org.sidiff.common.emf.modelstorage.Loader) -> a
    boolean releaseLoader(org.sidiff.common.emf.modelstorage.Loader) -> b
    java.lang.String loadEMF(java.lang.String) -> a
    org.eclipse.emf.ecore.resource.Resource loadEMF(java.lang.String,java.lang.String) -> a
    java.lang.String createResource(org.eclipse.emf.ecore.EObject[]) -> a
    org.eclipse.emf.ecore.resource.Resource createResource(java.lang.String,org.eclipse.emf.ecore.EObject[]) -> a
    boolean serialize(java.lang.String,java.lang.String) -> b
    java.lang.String importEMF(java.lang.String) -> b
    org.eclipse.emf.ecore.resource.Resource importEMF(java.lang.String,java.lang.String) -> c
    java.lang.String importEMFWith(java.lang.String,java.lang.Class) -> a
    org.eclipse.emf.ecore.resource.Resource importEMFWith(java.lang.String,java.lang.String,java.lang.Class) -> a
    org.eclipse.emf.ecore.resource.Resource getModel(java.lang.String) -> c
    void releaseModel(java.lang.String) -> d
    boolean canHandle(java.lang.String) -> e
    org.eclipse.emf.ecore.resource.Resource importEMF(java.lang.String,java.lang.String,org.sidiff.common.emf.modelstorage.Loader) -> a
    org.sidiff.common.emf.modelstorage.Loader getUsableLoader(java.lang.String) -> f
    org.eclipse.emf.ecore.resource.Resource createManagedResource(java.lang.String,java.lang.String,boolean) -> a
org.sidiff.common.emf.modelstorage.XSLTImporter -> org.sidiff.common.emf.modelstorage.b:
    java.lang.String USE_TEMPFILE_FOR_TRANSFORMATION -> USE_TEMPFILE_FOR_TRANSFORMATION
    java.lang.String getLoaderDescription() -> getLoaderDescription
    java.lang.String getXSLTDescription() -> getXSLTDescription
    java.lang.String getXSLTName() -> getXSLTName
    void parse(org.eclipse.emf.ecore.resource.Resource,java.io.InputStream) -> parse
    java.util.Map getLoadOptions() -> getLoadOptions
org.sidiff.common.emf.modelstorage.internal.ModelStorageCommandProvider -> org.sidiff.common.emf.modelstorage.internal.a:
    java.io.File workingDir -> a
    void _pwd(org.eclipse.osgi.framework.console.CommandInterpreter) -> a
    void _ls(org.eclipse.osgi.framework.console.CommandInterpreter) -> b
    void _cd(org.eclipse.osgi.framework.console.CommandInterpreter) -> c
    void _switch(org.eclipse.osgi.framework.console.CommandInterpreter) -> d
    void _load(org.eclipse.osgi.framework.console.CommandInterpreter) -> e
    void _import(org.eclipse.osgi.framework.console.CommandInterpreter) -> f
    void _check(org.eclipse.osgi.framework.console.CommandInterpreter) -> g
    void _remove(org.eclipse.osgi.framework.console.CommandInterpreter) -> h
    void _test(org.eclipse.osgi.framework.console.CommandInterpreter) -> i
    java.io.File checkForDir(java.io.File,java.lang.String) -> a
    java.lang.String getHelp() -> getHelp
org.sidiff.common.emf.selectors.EMFSelectors -> org.sidiff.common.emf.selectors.d:
    org.sidiff.common.collections.Selector byClass(org.eclipse.emf.ecore.EClass) -> a
    org.sidiff.common.collections.Selector byInstance(org.eclipse.emf.ecore.EClass) -> b
    org.sidiff.common.collections.Selector byResource(org.eclipse.emf.ecore.resource.Resource) -> a
    org.eclipse.emf.ecore.EObject getSingleElementFromResource(java.util.Collection,org.eclipse.emf.ecore.resource.Resource) -> a
org.sidiff.common.emf.selectors.EMFSelectors$1 -> org.sidiff.common.emf.selectors.c:
    org.eclipse.emf.ecore.EClass val$eClass -> a
    boolean select(org.eclipse.emf.ecore.EObject) -> a
    boolean select(java.lang.Object) -> a
org.sidiff.common.emf.selectors.EMFSelectors$2 -> org.sidiff.common.emf.selectors.b:
    org.eclipse.emf.ecore.EClass val$eClass -> a
    boolean select(org.eclipse.emf.ecore.EObject) -> a
    boolean select(java.lang.Object) -> a
org.sidiff.common.emf.selectors.EMFSelectors$3 -> org.sidiff.common.emf.selectors.a:
    org.eclipse.emf.ecore.resource.Resource val$resource -> a
    boolean select(org.eclipse.emf.ecore.EObject) -> a
    boolean select(java.lang.Object) -> a
org.sidiff.common.exceptions.SiDiffException -> org.sidiff.common.exceptions.a:
    long serialVersionUID -> a
    java.lang.Object[] message -> b
    java.lang.Exception originalException -> c
    java.lang.String getMessage() -> getMessage
    java.lang.Exception getOriginalException() -> a
    java.lang.Exception getOriginalException(java.lang.Object[]) -> a
org.sidiff.common.exceptions.SiDiffIOException -> org.sidiff.common.exceptions.b:
    long serialVersionUID -> a
    java.lang.Object[] message -> b
    java.lang.Exception originalException -> c
    java.lang.String getMessage() -> getMessage
    java.lang.Exception getOriginalException() -> a
    java.lang.Exception getOriginalException(java.lang.Object[]) -> a
org.sidiff.common.exceptions.SiDiffRuntimeException -> org.sidiff.common.exceptions.c:
    long serialVersionUID -> a
    java.lang.Object[] message -> b
    java.lang.Exception originalException -> c
    java.lang.String getMessage() -> getMessage
    java.lang.Exception getOriginalException() -> a
org.sidiff.common.io.IOUtil -> org.sidiff.common.io.a:
    boolean $assertionsDisabled -> a
    java.io.InputStream getInputStreamFromFile(java.lang.String) -> a
    java.io.InputStream getInputStreamFromString(java.lang.String) -> b
    java.io.InputStream getInputStreamFromResource(java.lang.String) -> c
    java.io.InputStream getInputStream(java.lang.String) -> d
    java.io.OutputStream getOutputStreamIntoFile(java.lang.String) -> e
    java.io.OutputStream getOutputStreamIntoString(java.lang.StringBuffer) -> a
    java.lang.String readFromStream(java.io.InputStream) -> a
    java.lang.String readFromStream(java.io.InputStream,int) -> a
    void writeToStream(java.lang.String,java.io.OutputStream,boolean) -> a
org.sidiff.common.io.IOUtil$StringInputStream -> org.sidiff.common.io.e:
    int position -> a
    java.lang.String data -> b
    int read() -> read
org.sidiff.common.io.IOUtil$StringOutputStream -> org.sidiff.common.io.d:
    java.lang.StringBuffer buffer -> a
    void write(int) -> write
org.sidiff.common.io.MapLoader -> org.sidiff.common.io.c:
    java.util.HashMap contentHandlers -> a
    void parseMapFromString(java.lang.String,java.util.Map,java.lang.String) -> a
    void parseMapFromStream(java.lang.String,java.util.Map,java.io.InputStream) -> a
    java.util.Map parseMapFromString(java.lang.String,java.lang.String) -> a
    java.util.Map parseMapFromStream(java.lang.String,java.io.InputStream) -> a
org.sidiff.common.io.ResourceUtil -> org.sidiff.common.io.b:
    java.util.ArrayList classLoaders -> b
    boolean $assertionsDisabled -> a
    java.util.List getClassLoaders() -> a
    void registerClassLoader(java.lang.ClassLoader) -> a
    void unregisterClassLoader(java.lang.ClassLoader) -> b
    java.io.InputStream getInputStreamByResourceName(java.lang.String) -> a
    java.lang.ClassLoader getClassLoaderByResourceName(java.lang.String) -> b
    java.lang.ClassLoader getClassLoaderByClassName(java.lang.String) -> c
org.sidiff.common.io.Serializer -> org.sidiff.common.io.Serializer:
    void serialize(java.io.OutputStream,java.lang.Object) -> a
org.sidiff.common.io.internal.InvalidMapTypeException -> org.sidiff.common.io.internal.a:
    long serialVersionUID -> a
org.sidiff.common.io.internal.MapContentHandler -> org.sidiff.common.io.internal.b:
    java.lang.String ELEM_MAP -> c
    java.lang.String ATT_MAP_TYPE -> d
    java.lang.String ELEM_MAPENTRY -> e
    java.lang.String ATT_MAPENTRY_KEY -> f
    java.lang.String ATT_MAPENTRY_VALUE -> g
    java.lang.String DEFAULT_VALUE_KEY -> a
    java.lang.String mapType -> h
    java.util.Map map -> i
    boolean $assertionsDisabled -> b
    void putMap(java.util.Map) -> a
    void startElement(java.lang.String,java.lang.String,java.lang.String,org.xml.sax.Attributes) -> startElement
    void processMapEntry(org.xml.sax.Attributes) -> a
    void checkMapType(org.xml.sax.Attributes) -> b
    void endDocument() -> endDocument
    void endElement(java.lang.String,java.lang.String,java.lang.String) -> endElement
    void startDocument() -> startDocument
    void characters(char[],int,int) -> characters
    void endPrefixMapping(java.lang.String) -> endPrefixMapping
    void ignorableWhitespace(char[],int,int) -> ignorableWhitespace
    void processingInstruction(java.lang.String,java.lang.String) -> processingInstruction
    void setDocumentLocator(org.xml.sax.Locator) -> setDocumentLocator
    void skippedEntity(java.lang.String) -> skippedEntity
    void startPrefixMapping(java.lang.String,java.lang.String) -> startPrefixMapping
org.sidiff.common.lcs.LCSSequenceAccessor -> org.sidiff.common.lcs.LCSSequenceAccessor:
    int size(java.lang.Object) -> a
    java.lang.Object get(java.lang.Object,int) -> a
org.sidiff.common.lcs.LCSSequenceAccessorEqualSubsequence -> org.sidiff.common.lcs.LCSSequenceAccessorEqualSubsequence:
    boolean areEqual(java.lang.Object,java.lang.Object) -> a
org.sidiff.common.lcs.LCSSequenceAccessorSimilarSubsequence -> org.sidiff.common.lcs.LCSSequenceAccessorSimilarSubsequence:
    float getSimilarity(java.lang.Object,java.lang.Object) -> a
org.sidiff.common.lcs.LCSUtil -> org.sidiff.common.lcs.LCSUtil:
    int compareSequenceByEqualSubsequence(java.lang.Object,java.lang.Object,org.sidiff.common.lcs.LCSSequenceAccessorEqualSubsequence) -> a
    float compareSequenceBySimilarSubsequence(java.lang.Object,java.lang.Object,org.sidiff.common.lcs.LCSSequenceAccessorSimilarSubsequence,float) -> a
    void main(java.lang.String[]) -> main
org.sidiff.common.lcs.LCSUtil$1 -> org.sidiff.common.lcs.c:
    boolean areEqual(java.lang.String,java.lang.String) -> a
    java.lang.String get(java.util.List,int) -> a
    int size(java.util.List) -> a
    java.lang.Object get(java.lang.Object,int) -> a
    boolean areEqual(java.lang.Object,java.lang.Object) -> a
    int size(java.lang.Object) -> a
org.sidiff.common.lcs.LCSUtil$2 -> org.sidiff.common.lcs.b:
    java.lang.String get(java.util.List,int) -> a
    int size(java.util.List) -> a
    float getSimilarity(java.lang.String,java.lang.String) -> a
    java.lang.Object get(java.lang.Object,int) -> a
    float getSimilarity(java.lang.Object,java.lang.Object) -> a
    int size(java.lang.Object) -> a
org.sidiff.common.lcs.StringLCSUtil -> org.sidiff.common.lcs.a:
    float compareStringConsideringCase(java.lang.String,java.lang.String) -> a
    float compareStringIgnoringCase(java.lang.String,java.lang.String) -> b
org.sidiff.common.lcs.StringLCSUtil$StringLCSSequenceAccessorEqualSubsequence -> org.sidiff.common.lcs.e:
    java.lang.Character get(java.lang.String,int) -> a
    int size(java.lang.String) -> a
    boolean areEqual(java.lang.Character,java.lang.Character) -> a
    java.lang.Object get(java.lang.Object,int) -> a
    boolean areEqual(java.lang.Object,java.lang.Object) -> a
    int size(java.lang.Object) -> a
org.sidiff.common.lcs.StringLCSUtil$StringLCSSequenceAccessorSimilarSubsequence -> org.sidiff.common.lcs.d:
    java.lang.Character get(java.lang.String,int) -> a
    int size(java.lang.String) -> a
    float getSimilarity(java.lang.Character,java.lang.Character) -> a
    java.lang.Object get(java.lang.Object,int) -> a
    float getSimilarity(java.lang.Object,java.lang.Object) -> a
    int size(java.lang.Object) -> a
org.sidiff.common.logging.LogEvent -> org.sidiff.common.logging.a:
    org.sidiff.common.logging.LogEvent MESSAGE -> a
    org.sidiff.common.logging.LogEvent ERROR -> b
    org.sidiff.common.logging.LogEvent WARNING -> c
    org.sidiff.common.logging.LogEvent NOTICE -> d
    org.sidiff.common.logging.LogEvent EVENT -> e
    org.sidiff.common.logging.LogEvent SIGNAL -> f
    org.sidiff.common.logging.LogEvent DEBUG -> g
    java.lang.String eventstring -> h
    org.sidiff.common.logging.LogEvent[] ENUM$VALUES -> i
    java.lang.String toString() -> toString
    org.sidiff.common.logging.LogEvent[] values() -> values
    org.sidiff.common.logging.LogEvent valueOf(java.lang.String) -> valueOf
org.sidiff.common.logging.LogUtil -> org.sidiff.common.logging.b:
    boolean IS_RELEASE -> b
    java.lang.String PROPERTY_NAME_LOGCHANNEL -> c
    java.lang.String PROPERTY_NAME_MODULES -> d
    java.lang.String PROPERTY_NAME_EVENTS -> e
    java.lang.String OPTION_SEPARATOR -> f
    java.lang.String WILDCARD -> g
    int MODULE_INDEX -> h
    java.lang.String CHANNEL_PREFIX -> i
    java.lang.String DEFAULT_OUTPUT_CHANNEL -> j
    java.lang.String DEFAULT_OUTPUT_CHANNEL_OSGI -> k
    java.lang.String DEFAULTLOGEVENTS -> l
    org.sidiff.common.logging.internal.LogChannel channel -> m
    java.text.SimpleDateFormat sdf -> n
    java.util.EnumSet logevents -> o
    java.util.Set logmodules -> p
    boolean $assertionsDisabled -> a
    java.lang.String getLogEvents() -> a
    void setLogEvents(java.lang.String) -> a
    void setLogModules(java.lang.String) -> c
    void setLogChannel(java.lang.String) -> b
    boolean doLogModule(java.lang.String) -> d
    boolean doLogEvent(org.sidiff.common.logging.LogEvent) -> a
    java.lang.String getModuleName(java.lang.String[]) -> a
    java.lang.String getCallerName(java.lang.String[]) -> b
    void printInternal(java.lang.String,org.sidiff.common.logging.LogEvent,java.lang.Object[]) -> a
    boolean log(org.sidiff.common.logging.LogEvent,java.lang.Object[]) -> a
org.sidiff.common.logging.internal.ConsoleLogChannel -> org.sidiff.common.logging.internal.c:
    java.io.PrintWriter log -> a
    java.text.SimpleDateFormat createDateFormat() -> a
    void log(java.lang.String,org.sidiff.common.logging.LogEvent) -> a
    boolean doIndentation() -> d
    boolean includeLogEvent() -> c
    boolean includeTimeStamp() -> b
org.sidiff.common.logging.internal.FileLogChannel -> org.sidiff.common.logging.internal.d:
    java.lang.String PROPERTY_NAME_LOGFILE -> a
    java.io.PrintWriter log -> b
    java.text.SimpleDateFormat createDateFormat() -> a
    void log(java.lang.String,org.sidiff.common.logging.LogEvent) -> a
    boolean doIndentation() -> d
    boolean includeLogEvent() -> c
    boolean includeTimeStamp() -> b
org.sidiff.common.logging.internal.LogChannel -> org.sidiff.common.logging.internal.LogChannel:
    void log(java.lang.String,org.sidiff.common.logging.LogEvent) -> a
    java.text.SimpleDateFormat createDateFormat() -> a
    boolean includeTimeStamp() -> b
    boolean includeLogEvent() -> c
    boolean doIndentation() -> d
org.sidiff.common.logging.internal.OSGILogChannel -> org.sidiff.common.logging.internal.a:
    org.osgi.framework.BundleContext context -> a
    org.osgi.framework.ServiceReference logServiceRef -> b
    boolean hasPrintedError -> c
    int[] $SWITCH_TABLE$org$sidiff$common$logging$LogEvent -> d
    java.text.SimpleDateFormat createDateFormat() -> a
    void log(java.lang.String,org.sidiff.common.logging.LogEvent) -> a
    org.osgi.service.log.LogService getLogService() -> f
    int toOSGILogLevel(org.sidiff.common.logging.LogEvent) -> a
    boolean doIndentation() -> d
    boolean includeLogEvent() -> c
    boolean includeTimeStamp() -> b
    int[] $SWITCH_TABLE$org$sidiff$common$logging$LogEvent() -> e
org.sidiff.common.logging.internal.TeePipeChannel -> org.sidiff.common.logging.internal.b:
    java.lang.String PROPERTY_NAME_LOGCHANNELS -> d
    java.lang.String CHANNEL_PREFIX -> e
    java.lang.String CHANNEL_SEPARATOR -> f
    java.lang.String EVENT_DECLARATOR -> g
    java.lang.String EVENT_SEPARATOR -> h
    java.util.HashMap channelEvents -> i
    boolean doIndentationFlag -> a
    boolean includeLogEventFlag -> b
    boolean includeTimeStampFlag -> c
    org.sidiff.common.logging.internal.LogChannel getOutputChannel(java.lang.String) -> a
    void setFormatting() -> e
    java.text.SimpleDateFormat createDateFormat() -> a
    boolean doIndentation() -> d
    boolean includeLogEvent() -> c
    boolean includeTimeStamp() -> b
    void log(java.lang.String,org.sidiff.common.logging.LogEvent) -> a
org.sidiff.common.services.Activator -> org.sidiff.common.services.g:
    void start(org.osgi.framework.BundleContext) -> start
    void stop(org.osgi.framework.BundleContext) -> stop
org.sidiff.common.services.ConfigurableProvidableService -> org.sidiff.common.services.ConfigurableProvidableService:
org.sidiff.common.services.ConfigurableService -> org.sidiff.common.services.ConfigurableService:
    java.lang.String configure(java.lang.Object[]) -> a
    void deconfigure() -> b
    java.util.Dictionary getProperties() -> c
org.sidiff.common.services.ConfigurableServiceProvider -> org.sidiff.common.services.ConfigurableServiceProvider:
org.sidiff.common.services.ContextSensitiveService -> org.sidiff.common.services.ContextSensitiveService:
    void initialize(org.sidiff.common.services.ServiceContext,java.lang.Object[]) -> a
org.sidiff.common.services.DelayedBundleActivator -> org.sidiff.common.services.b:
    org.osgi.framework.BundleListener listener -> a
    boolean check(org.osgi.framework.BundleContext,java.lang.String) -> a
    void start(org.osgi.framework.BundleContext) -> a
    java.lang.String bundleToWaitFor() -> a
    boolean access$0(org.sidiff.common.services.DelayedBundleActivator,org.osgi.framework.BundleContext,java.lang.String) -> a
org.sidiff.common.services.DelayedBundleActivator$1 -> org.sidiff.common.services.f:
    org.sidiff.common.services.DelayedBundleActivator this$0 -> a
    org.osgi.framework.BundleContext val$context -> b
    void bundleChanged(org.osgi.framework.BundleEvent) -> bundleChanged
org.sidiff.common.services.IllegalInitializationException -> org.sidiff.common.services.c:
    long serialVersionUID -> a
org.sidiff.common.services.ProvidableService -> org.sidiff.common.services.ProvidableService:
org.sidiff.common.services.Service -> org.sidiff.common.services.Service:
org.sidiff.common.services.ServiceConfigurator -> org.sidiff.common.services.i:
    java.lang.String CONFIGURATOR_SUFFIX -> a
    java.lang.Class interfaceClass -> b
    java.lang.Class implementationClass -> c
    java.lang.Class getInterfaceClass() -> a
    java.lang.Class getImplementationClass() -> b
    void registerVariantInstance(org.osgi.framework.BundleContext,java.lang.String,java.lang.String,java.lang.Object[]) -> a
    void unregister(org.osgi.framework.BundleContext) -> a
    void unregisterVariantInstance(org.osgi.framework.BundleContext,java.lang.String,java.lang.String) -> a
org.sidiff.common.services.ServiceContext -> org.sidiff.common.services.j:
    boolean isInitialized -> b
    java.util.Map servicesInContext -> c
    java.util.Set hiddenServices -> d
    java.util.Map initSequences -> e
    int[] defaultSequence -> f
    java.lang.Object[] initParameters -> g
    java.util.Set initializedServices -> h
    java.util.Map eventDispatcher -> i
    org.sidiff.common.services.events.EventDispatcher globalEventDispatcher -> j
    boolean $assertionsDisabled -> a
    boolean putHiddenService(org.sidiff.common.services.ContextSensitiveService) -> a
    boolean removeHiddenService(java.lang.Object) -> a
    boolean isInitialized() -> a
    void initialize(java.lang.Object[]) -> a
    void initialize(org.sidiff.common.services.ContextSensitiveService) -> b
    void setDefaultParams(int[]) -> a
    boolean containsService(java.lang.Class) -> a
    boolean containsService(java.lang.Object) -> b
    java.lang.Object getService(java.lang.Class) -> b
    java.util.Set supportedServices() -> b
    java.lang.Object putService(java.lang.Class,java.lang.Object,int[]) -> a
    boolean putService(org.sidiff.common.services.Service,int[]) -> a
    java.lang.Object removeService(java.lang.Class,java.lang.Object) -> a
    java.util.Collection getServices() -> c
    java.util.Collection getServiceIDs() -> d
    java.lang.Iterable getServices(java.lang.Class) -> c
    boolean fireEvent(org.sidiff.common.services.events.SCEvent) -> a
    boolean addEventListener(java.lang.Class,org.sidiff.common.services.events.SCEventListener) -> a
    void removeEventListner(java.lang.Class,org.sidiff.common.services.events.SCEventListener) -> b
org.sidiff.common.services.ServiceContext$MissingServiceException -> org.sidiff.common.services.d:
org.sidiff.common.services.ServiceHelper -> org.sidiff.common.services.a:
    java.lang.String RANKING -> c
    java.lang.String VARIANT -> a
    java.lang.String DOCTYPE -> b
    java.util.HashMap configurators -> d
    java.util.List getServiceHierachy(java.lang.Class) -> a
    void getServiceHierachy(java.util.ArrayList,java.lang.Class) -> a
    java.lang.Class getServiceInterface(java.lang.Class) -> b
    java.util.List getProviderHierachy(org.sidiff.common.services.ServiceProvider) -> a
    void getProviderHierachy(java.util.ArrayList,java.lang.Class) -> b
    void registerService(org.osgi.framework.BundleContext,java.lang.Class,java.lang.Object,java.lang.String,java.lang.String) -> a
    void registerService(org.osgi.framework.BundleContext,java.lang.Class,java.lang.Object,java.lang.String,java.lang.String,java.util.Dictionary) -> a
    void registerServiceProvider(org.osgi.framework.BundleContext,java.lang.Class,org.sidiff.common.services.ServiceProvider,java.lang.String,java.lang.String) -> a
    void registerServiceProvider(org.osgi.framework.BundleContext,java.lang.Class,org.sidiff.common.services.ServiceProvider,java.lang.String,java.lang.String,java.util.Dictionary) -> a
    java.lang.String getFilter(boolean,java.lang.String,java.lang.String) -> a
    java.lang.Object getService(org.osgi.framework.BundleContext,java.lang.Class) -> a
    java.lang.Object getService(org.osgi.framework.BundleContext,java.lang.Class,java.lang.String) -> a
    java.lang.Object getService(org.osgi.framework.BundleContext,java.lang.Class,java.lang.String,java.lang.String) -> a
    void registerServiceConfigurator(org.osgi.framework.BundleContext,java.lang.Class,java.lang.Class) -> a
    org.sidiff.common.services.ServiceConfigurator getServiceConfigurator(java.lang.Class) -> c
    void configureInstance(org.osgi.framework.BundleContext,java.lang.Class,java.lang.String,java.lang.String,java.lang.Object[]) -> a
    void unregisterInstances(org.osgi.framework.BundleContext,java.lang.Class) -> b
    void unregisterVariantInstance(org.osgi.framework.BundleContext,java.lang.Class,java.lang.String,java.lang.String) -> b
    boolean isAvailable(java.lang.String) -> a
org.sidiff.common.services.ServiceHelper$ServiceComparator -> org.sidiff.common.services.h:
    int compare(org.osgi.framework.ServiceReference,org.osgi.framework.ServiceReference) -> a
    int compare(java.lang.Object,java.lang.Object) -> compare
org.sidiff.common.services.ServiceProvider -> org.sidiff.common.services.ServiceProvider:
    java.lang.String PROVIDER_SUFFIX -> a
    java.lang.Object createInstance() -> a
org.sidiff.common.services.SiDiffCompareInterface -> org.sidiff.common.services.e:
    org.sidiff.common.services.ServiceContext serviceContext -> a
    java.lang.String variant -> b
    org.sidiff.common.services.ServiceContext getServiceContext() -> a
    void createContext(java.lang.Object[]) -> a
    java.lang.String getVariant() -> b
    java.lang.String getDocumentType() -> c
    java.lang.String getDescription() -> d
    void compare(java.lang.Object[]) -> b
org.sidiff.common.services.debug.SiDiffDebugger -> org.sidiff.common.services.debug.a:
    org.sidiff.common.services.debug.SiDiffDebugger INSTANCE -> a
    org.sidiff.common.services.ServiceContext serviceContext -> b
    java.util.HashMap debuggers -> c
    java.util.HashMap shortCutDebuggers -> d
    java.util.ArrayList resources -> e
    java.util.HashMap elements -> f
    java.util.List IGNORED_METHODS -> g
    org.sidiff.common.services.debug.SiDiffDebugger getInstance() -> a
    void initialize(org.sidiff.common.services.ServiceContext,java.lang.Object[]) -> a
    void addDebugger(java.lang.Object) -> a
    void addDebugger(java.lang.String,java.lang.Object) -> a
    org.eclipse.emf.ecore.EObject getElement(java.lang.String) -> a
    org.eclipse.emf.ecore.resource.Resource getResource(java.lang.String) -> b
    boolean initialized(org.eclipse.osgi.framework.console.CommandInterpreter) -> h
    java.lang.String getHelp() -> getHelp
    void _resources(org.eclipse.osgi.framework.console.CommandInterpreter) -> a
    void _debuggers(org.eclipse.osgi.framework.console.CommandInterpreter) -> b
    void _shortcuts(org.eclipse.osgi.framework.console.CommandInterpreter) -> c
    void setShortcut(java.lang.String,java.lang.String) -> a
    void _setsc(org.eclipse.osgi.framework.console.CommandInterpreter) -> d
    java.lang.Object getDebugger(java.lang.String) -> c
    void _debuggerinfo(org.eclipse.osgi.framework.console.CommandInterpreter) -> e
    void _debug2file(org.eclipse.osgi.framework.console.CommandInterpreter) -> f
    void _debug(org.eclipse.osgi.framework.console.CommandInterpreter) -> g
org.sidiff.common.services.debug.SiDiffDebugger$1 -> org.sidiff.common.services.debug.b:
    org.sidiff.common.services.debug.SiDiffDebugger this$0 -> a
    java.io.PrintWriter val$out -> b
    org.eclipse.osgi.framework.console.CommandInterpreter val$commandInterpreter -> c
    void println(java.lang.Object) -> println
    void println() -> println
    void printStackTrace(java.lang.Throwable) -> printStackTrace
    void printDictionary(java.util.Dictionary,java.lang.String) -> printDictionary
    void printBundleResource(org.osgi.framework.Bundle,java.lang.String) -> printBundleResource
    void print(java.lang.Object) -> print
    java.lang.String nextArgument() -> nextArgument
    java.lang.Object execute(java.lang.String) -> execute
org.sidiff.common.services.events.EventDispatcher -> org.sidiff.common.services.events.a:
    java.lang.Class eventClass -> b
    java.util.Set listeners -> c
    boolean $assertionsDisabled -> a
    boolean addEventListener(org.sidiff.common.services.events.SCEventListener) -> a
    boolean removeEventListener(org.sidiff.common.services.events.SCEventListener) -> b
    boolean fireEvent(org.sidiff.common.services.events.SCEvent) -> a
    boolean isEmpty() -> a
org.sidiff.common.services.events.SCEvent -> org.sidiff.common.services.events.b:
    long serialVersionUID -> a
    int EVENT_ID -> b
    int eventID -> c
    java.lang.Object[] objects -> d
    boolean $assertionsDisabled -> j
    int getEventID() -> a
    java.lang.Object getObject(int,java.lang.Class) -> a
    int createNewEvent() -> b
org.sidiff.common.services.events.SCEventListener -> org.sidiff.common.services.events.SCEventListener:
    void eventDispatched(org.sidiff.common.services.events.SCEvent) -> a
org.sidiff.common.util.ParameterUtil -> org.sidiff.common.util.ParameterUtil:
    java.lang.String PARAM_SEPARATOR -> a
    boolean $assertionsDisabled -> b
    java.lang.String[] getParameterSegments(java.lang.String) -> a
    java.lang.String getTopLevelParameterString(java.lang.String) -> b
    boolean hasNestedParameter(java.lang.String) -> c
    java.lang.String[] splitCompositeParamter(java.lang.String) -> d
    void main(java.lang.String[]) -> main
    void printArray(java.lang.String[]) -> a
org.sidiff.common.util.ReflectionUtil -> org.sidiff.common.util.a:
    boolean $assertionsDisabled -> a
    java.lang.Object createInstance(java.lang.Class,java.lang.Object[]) -> a
    java.lang.Object createInstance(java.lang.String,java.lang.Class,java.lang.Object[]) -> a
    java.lang.reflect.Constructor getConstructor(java.lang.Class,java.lang.Object[]) -> b
    java.lang.Object invokeStaticMethod(java.lang.Class,java.lang.Class,java.lang.String,java.lang.Object[]) -> a
    java.lang.Object invokeStaticMethod(java.lang.Class,java.lang.reflect.Method,java.lang.Object[]) -> a
    java.lang.Class loadClass(java.lang.String) -> a
    int computeInheritanceDistance(java.lang.Class,java.lang.Class) -> a
org.sidiff.common.util.SiDiffUIUtil -> org.sidiff.common.util.c:
    void showDataFrame(java.lang.String,java.lang.String) -> a
    void showHtmlFrame(java.lang.String,java.lang.String) -> b
org.sidiff.common.util.StatisticsUtil -> org.sidiff.common.util.b:
    java.lang.String STAT_KEY_STARTTIME -> a
    java.lang.String STAT_KEY_SIZE -> b
    java.lang.String STAT_KEY_TIME -> c
    java.lang.String STAT_KEY_COUNTER -> d
    java.util.HashMap statisticalInformation -> e
    org.sidiff.common.util.StatisticsUtil instance -> f
    boolean checkKey(java.lang.String) -> g
    org.sidiff.common.util.StatisticsUtil getInstance() -> a
    void reset() -> b
    void resetCounters(java.lang.String) -> a
    void resetSizes(java.lang.String) -> b
    void reset(java.lang.String) -> c
    void start(java.lang.Object) -> a
    float stop(java.lang.Object) -> b
    void resetTime(java.lang.Object) -> c
    float getTime(java.lang.Object) -> d
    java.lang.Object getObject(java.lang.String) -> d
    java.lang.String getString(java.lang.String) -> e
    int getInt(java.lang.String) -> f
    void put(java.lang.String,java.lang.Object) -> a
    void put(java.lang.String,int) -> a
    void putSize(java.lang.Object,int) -> a
    int getSize(java.lang.Object) -> e
    int getCounter(java.lang.Object) -> f
    void resetCounter(java.lang.Object) -> g
    void count(java.lang.Object) -> h
    boolean isSizeSet(java.lang.Object) -> i
    boolean isCounterSet(java.lang.Object) -> j
    boolean isTimeSet(java.lang.Object) -> k
    java.lang.String dump() -> c
    java.util.Map getAsStringMap() -> d
org.sidiff.common.util.StringUtil -> org.sidiff.common.util.d:
    java.util.HashMap resolvers -> b
    boolean $assertionsDisabled -> a
    boolean addStringResolver(org.sidiff.common.util.internal.StringResolver) -> a
    boolean removeStringResolver(java.lang.Class) -> a
    boolean removeStringResolver(org.sidiff.common.util.internal.StringResolver) -> b
    java.lang.String resolve(java.lang.Object) -> a
    java.lang.String resolve(java.lang.Object[]) -> a
    java.lang.String concat(java.lang.String[]) -> a
    java.lang.String normalize(java.lang.String) -> a
    int count(java.lang.String,java.lang.String) -> a
org.sidiff.common.util.internal.ArrayStringResolver -> org.sidiff.common.util.internal.h:
    java.lang.Class dedicatedClass() -> a
    java.lang.String resolve(java.lang.Object) -> a
org.sidiff.common.util.internal.CollectionStringResolver -> org.sidiff.common.util.internal.d:
    java.lang.Class dedicatedClass() -> a
    java.lang.String resolve(java.lang.Object) -> a
org.sidiff.common.util.internal.ErrorStringResolver -> org.sidiff.common.util.internal.g:
    java.lang.Class dedicatedClass() -> a
    java.lang.String resolve(java.lang.Object) -> a
org.sidiff.common.util.internal.ExceptionStringResolver -> org.sidiff.common.util.internal.c:
    java.lang.Class dedicatedClass() -> a
    java.lang.String resolve(java.lang.Object) -> a
org.sidiff.common.util.internal.HashTableStringResolver -> org.sidiff.common.util.internal.b:
    java.lang.Class dedicatedClass() -> a
    java.lang.String resolve(java.lang.Object) -> a
org.sidiff.common.util.internal.MapStringResolver -> org.sidiff.common.util.internal.e:
    java.lang.Class dedicatedClass() -> a
    java.lang.String resolve(java.lang.Object) -> a
org.sidiff.common.util.internal.StackTraceStringResolver -> org.sidiff.common.util.internal.f:
    java.lang.String resolve(java.lang.Object) -> a
    java.lang.Class dedicatedClass() -> a
org.sidiff.common.util.internal.StringResolver -> org.sidiff.common.util.internal.StringResolver:
    java.lang.Class dedicatedClass() -> a
    java.lang.String resolve(java.lang.Object) -> a
org.sidiff.common.util.internal.ThreadStringResolver -> org.sidiff.common.util.internal.a:
    java.lang.Class dedicatedClass() -> a
    java.lang.String resolve(java.lang.Object) -> a
org.sidiff.common.xml.XMLDOMCreator -> org.sidiff.common.xml.e:
    org.w3c.dom.Document createDocument() -> a
    void writeDocument(java.io.OutputStream,org.w3c.dom.Document) -> a
org.sidiff.common.xml.XMLDOMCreator$DOMSerializerException -> org.sidiff.common.xml.f:
    long serialVersionUID -> a
org.sidiff.common.xml.XMLParser -> org.sidiff.common.xml.d:
    java.lang.String DEFAULT_PARSER_NAME_SAX -> a
    java.util.List saxParserPool -> b
    java.util.List domParserPool -> c
    org.xml.sax.ErrorHandler errorHandler -> d
    javax.xml.xpath.XPathFactory factory -> e
    javax.xml.xpath.XPath xpath -> f
    void parseStream(java.io.InputStream,org.xml.sax.ContentHandler) -> a
    org.w3c.dom.Document parseStream(java.io.InputStream) -> a
    org.w3c.dom.Document parseXML(org.xml.sax.InputSource) -> a
    void parseXML(org.xml.sax.InputSource,org.xml.sax.ContentHandler) -> a
    void setFeature(org.sidiff.common.xml.XMLParser$ParserFeature,boolean) -> a
    org.xml.sax.XMLReader createSAXParser() -> a
    org.apache.xerces.parsers.DOMParser createDOMParser() -> b
    org.w3c.dom.NodeList processXPath(org.w3c.dom.Document,java.lang.String) -> a
org.sidiff.common.xml.XMLParser$ParserFeature -> org.sidiff.common.xml.b:
    org.sidiff.common.xml.XMLParser$ParserFeature NAMESPACES_FEATURE -> a
    org.sidiff.common.xml.XMLParser$ParserFeature VALIDATION_FEATURE -> b
    org.sidiff.common.xml.XMLParser$ParserFeature SCHEMA_VALIDATION_FEATURE -> c
    org.sidiff.common.xml.XMLParser$ParserFeature SCHEMA_FULL_CHECKING_FEATURE -> d
    org.sidiff.common.xml.XMLParser$ParserFeature HONOUR_ALL_SCHEMA_LOCATIONS -> e
    org.sidiff.common.xml.XMLParser$ParserFeature VALIDATE_ANNOTATIONS -> f
    org.sidiff.common.xml.XMLParser$ParserFeature DYNAMIC_VALIDATION_FEATURE -> g
    org.sidiff.common.xml.XMLParser$ParserFeature XINCLUDE_FEATURE -> h
    org.sidiff.common.xml.XMLParser$ParserFeature XINCLUDE_FIXUP_BASE_URIS_FEATURE -> i
    org.sidiff.common.xml.XMLParser$ParserFeature XINCLUDE_FIXUP_LANGUAGE_FEATURE -> j
    java.lang.String featureID -> k
    boolean featureValue -> l
    org.sidiff.common.xml.XMLParser$ParserFeature[] ENUM$VALUES -> m
    org.sidiff.common.xml.XMLParser$ParserFeature[] values() -> values
    org.sidiff.common.xml.XMLParser$ParserFeature valueOf(java.lang.String) -> valueOf
    void access$2(org.sidiff.common.xml.XMLParser$ParserFeature,boolean) -> a
    java.lang.String access$3(org.sidiff.common.xml.XMLParser$ParserFeature) -> a
    boolean access$4(org.sidiff.common.xml.XMLParser$ParserFeature) -> b
org.sidiff.common.xml.XMLParser$XMLErrorHander -> org.sidiff.common.xml.g:
    void error(org.xml.sax.SAXParseException) -> error
    void fatalError(org.xml.sax.SAXParseException) -> fatalError
    void warning(org.xml.sax.SAXParseException) -> warning
org.sidiff.common.xml.XMLResolver -> org.sidiff.common.xml.h:
    java.lang.String DTDMAPPING_MAPTYPE -> b
    java.lang.String BOOTSTRAP_FILENAME -> c
    org.sidiff.common.xml.XMLResolver instance -> d
    java.util.Hashtable mappings -> e
    java.util.ArrayList loadedMappingDatas -> f
    boolean $assertionsDisabled -> a
    org.xml.sax.InputSource resolveEntity(java.lang.String,java.lang.String) -> resolveEntity
    javax.xml.transform.Source resolve(java.lang.String,java.lang.String) -> resolve
    void putMapping(java.lang.String,java.lang.String) -> a
    org.sidiff.common.xml.XMLResolver getInstance() -> a
    void includeMapping(java.lang.String) -> a
org.sidiff.common.xml.XMLTransformer -> org.sidiff.common.xml.a:
    java.io.InputStream transform(java.io.InputStream,java.io.InputStream) -> a
    java.io.InputStream transformUsingTempfile(java.io.InputStream,java.io.InputStream) -> b
    void transform(java.io.InputStream,java.io.OutputStream,java.io.InputStream) -> a
    void transform(org.xml.sax.InputSource,javax.xml.transform.Result,org.xml.sax.InputSource) -> a
org.sidiff.common.xml.XMLWriter -> org.sidiff.common.xml.c:
    java.lang.String TAB -> j
    java.lang.String XML_HEADER -> a
    java.lang.String XML_COMMENT_VAR -> b
    java.lang.String XML_COMMENT -> c
    java.lang.String DOCTYPE_ROOTELEMENT_VAR -> d
    java.lang.String DOCTYPE_TYPE_VAR -> e
    java.lang.String DOCTYPE_TYPE_DEFINITION -> f
    java.lang.String XML_DOCTYPE -> g
    java.lang.String XML_CDATA_VAR -> h
    java.lang.String XML_CDATA -> i
    int indentLevel -> k
    java.util.Stack openElements -> l
    java.util.Map charTranslationMap -> m
    java.util.Map idTranslationMap -> n
    java.util.Map idValidationMap -> o
    java.io.Writer out -> p
    void setNamespace(java.lang.String,java.lang.String) -> a
    void initDocument(java.lang.String) -> a
    void initDocument(java.lang.String,java.lang.String) -> b
    void initDocument(java.lang.String,java.lang.String[][],java.lang.String) -> a
    void initDocument(java.lang.String,java.lang.String[][],java.lang.String,java.util.Map) -> a
    void initDocumentEnhanced(java.lang.String,java.lang.String,java.lang.String,java.util.Map) -> a
    void finishDocument() -> a
    void generateComment(java.lang.String) -> b
    void generateStartTag(java.lang.String,java.util.Map) -> a
    void generateEmptyTag(java.lang.String,java.util.Map) -> b
    void generateEndTag(java.lang.String) -> c
    void generateText(java.lang.String,boolean) -> a
    void generateTabs() -> b
    void initIdValidation(java.lang.String[][]) -> a
    void initIdTranslations() -> c
    void initCharTranslations() -> d
    java.lang.String escape(java.lang.String) -> d
    java.lang.String translate(java.lang.String,java.util.Map) -> c
    java.lang.String validateID(java.lang.String,java.lang.String,java.lang.String) -> a
    void generateStartOrEmptyTag(java.lang.String,java.util.Map) -> d
    void performException(java.lang.Exception) -> a
org.sidiff.core.annotation.AnnotationException -> org.sidiff.core.annotation.b:
org.sidiff.core.annotation.AnnotationService -> org.sidiff.core.annotation.AnnotationService:
    void annotate(org.eclipse.emf.ecore.resource.Resource) -> a
    void annotate(org.eclipse.emf.ecore.EObject) -> a
    void annotate(org.eclipse.emf.ecore.resource.Resource,java.lang.String) -> a
    void annotate(org.eclipse.emf.ecore.EObject,java.lang.String) -> a
    void removeAnnotation(org.eclipse.emf.ecore.resource.Resource,java.lang.String) -> b
    void removeAllAnnotations(org.eclipse.emf.ecore.resource.Resource) -> b
    boolean hasAnnotation(java.lang.String) -> a
org.sidiff.core.annotation.AnnotationServiceProvider -> org.sidiff.core.annotation.AnnotationServiceProvider:
org.sidiff.core.annotation.Annotator -> org.sidiff.core.annotation.d:
    java.lang.String EXECUTED_ANNOATIONS -> k
    java.lang.String annotationKey -> a
    java.lang.String parameter -> b
    java.util.List acceptedTypes -> c
    org.sidiff.common.emf.annotation.AnnotationKeyList requiredAnnotations -> d
    org.sidiff.core.annotation.Annotator$ExecutionOrder order -> e
    boolean isActive -> f
    java.lang.String documentType -> g
    java.lang.String getAnnotationKey() -> b
    java.util.List getAcceptedTypes() -> c
    java.lang.String getParameter() -> d
    java.util.List getRequiredAnnotations() -> e
    void addRequirement(java.lang.String) -> b
    org.sidiff.core.annotation.Annotator$ExecutionOrder getOrder() -> f
    java.lang.String getDocumentType() -> g
    boolean accept(org.eclipse.emf.ecore.EObject) -> g
    void checkRequirements() -> h
    void init(org.eclipse.emf.ecore.EObject) -> b
    void finish(org.eclipse.emf.ecore.EObject) -> a
    void postExecute(org.eclipse.emf.ecore.EObject) -> c
    boolean preExecute(org.eclipse.emf.ecore.EObject) -> d
    void annotate(org.eclipse.emf.ecore.EObject) -> f
    java.lang.Object computeAnnotationValue(org.eclipse.emf.ecore.EObject) -> e
    org.sidiff.core.annotation.Annotator clone() -> i
    java.lang.Object clone() -> clone
org.sidiff.core.annotation.Annotator$ExecutionOrder -> org.sidiff.core.annotation.c:
    org.sidiff.core.annotation.Annotator$ExecutionOrder PRE -> a
    org.sidiff.core.annotation.Annotator$ExecutionOrder POST -> b
    org.sidiff.core.annotation.Annotator$ExecutionOrder[] ENUM$VALUES -> c
    org.sidiff.core.annotation.Annotator$ExecutionOrder[] values() -> values
    org.sidiff.core.annotation.Annotator$ExecutionOrder valueOf(java.lang.String) -> valueOf
org.sidiff.core.annotation.AnnotatorReference -> org.sidiff.core.annotation.a:
    java.lang.Class annotator -> a
    java.lang.String annotationKey -> b
    java.lang.String parameter -> c
    java.util.List acceptedTypes -> d
    java.util.List requiredAnnotations -> e
    org.sidiff.core.annotation.Annotator$ExecutionOrder order -> f
    java.lang.String description -> g
    java.lang.String documentType -> h
    java.lang.String getAnnotationKey() -> a
    void setAnnotationKey(java.lang.String) -> a
    java.lang.String getParameter() -> b
    void setParameter(java.lang.String) -> b
    java.util.List getAcceptedTypes() -> c
    void setAcceptedTypes(java.util.List) -> a
    java.util.List getRequiredAnnotations() -> d
    void setRequiredAnnotations(java.util.List) -> b
    org.sidiff.core.annotation.Annotator$ExecutionOrder getOrder() -> e
    void setOrder(org.sidiff.core.annotation.Annotator$ExecutionOrder) -> a
    void setAnnotator(java.lang.Class) -> a
    java.lang.Class getAnnotator() -> f
    java.lang.String toString() -> toString
    java.lang.String getDescription() -> g
    void setDocumentType(java.lang.String) -> c
    java.lang.String getDocumentType() -> h
org.sidiff.core.annotation.DefaultAnnotationService -> org.sidiff.core.annotation.DefaultAnnotationService:
org.sidiff.core.annotation.DefaultAnnotationServiceProvider -> org.sidiff.core.annotation.DefaultAnnotationServiceProvider:
org.sidiff.core.annotation.MissingRequirementException -> org.sidiff.core.annotation.e:
org.sidiff.core.annotation.impl.Activator -> org.sidiff.core.annotation.impl.d:
    void start(org.osgi.framework.BundleContext) -> start
    void stop(org.osgi.framework.BundleContext) -> stop
org.sidiff.core.annotation.impl.AnnotationConfigurationContentHandler -> org.sidiff.core.annotation.impl.b:
    java.lang.String DEFAULT_OPERATION_PREFIX -> a
    java.lang.String SEPERATOR -> b
    java.lang.String WILDCAT -> c
    java.lang.String ELEM_GLOBALSETTINGS -> d
    java.lang.String ATT_GS_OPPREFIX -> e
    java.lang.String ATT_GS_DOCTYPE -> f
    java.lang.String ELEM_ANNOTATION -> g
    java.lang.String ATT_NODETYPE -> h
    java.lang.String ELEM_SYNTH_ATTR -> i
    java.lang.String ATT_SA_OPERATION -> j
    java.lang.String ATT_SA_NAME -> k
    java.lang.String ATT_SA_PARAMETER -> l
    java.lang.String ATT_SA_REQUIRES -> m
    java.lang.String ATT_SA_DESCRIPTION -> n
    java.lang.String ELEM_PREORDER -> o
    java.lang.String ELEM_POSTORDER -> p
    java.util.ArrayList annotatorReferences -> q
    java.lang.String operationPrefixString -> r
    java.lang.String documentType -> s
    java.util.List currentClassifiers -> t
    org.sidiff.core.annotation.Annotator$ExecutionOrder currentOrder -> u
    java.util.ArrayList getAnnotatorReferences() -> a
    java.lang.String getDocumentType() -> b
    void startDocument() -> startDocument
    void endDocument() -> endDocument
    void startElement(java.lang.String,java.lang.String,java.lang.String,org.xml.sax.Attributes) -> startElement
    void endElement(java.lang.String,java.lang.String,java.lang.String) -> endElement
    void prepareAnnotation(org.xml.sax.Attributes) -> a
    void processAttribute(org.xml.sax.Attributes) -> b
    void processGlobalSettings(org.xml.sax.Attributes) -> c
    void preparePreOrder(org.xml.sax.Attributes) -> d
    void preparePostOrder(org.xml.sax.Attributes) -> e
    void finishAnyOrder() -> c
    void finishAnnotation() -> d
    void characters(char[],int,int) -> characters
    void endPrefixMapping(java.lang.String) -> endPrefixMapping
    void ignorableWhitespace(char[],int,int) -> ignorableWhitespace
    void processingInstruction(java.lang.String,java.lang.String) -> processingInstruction
    void setDocumentLocator(org.xml.sax.Locator) -> setDocumentLocator
    void skippedEntity(java.lang.String) -> skippedEntity
    void startPrefixMapping(java.lang.String,java.lang.String) -> startPrefixMapping
org.sidiff.core.annotation.impl.DefaultAnnotationServiceImpl -> org.sidiff.core.annotation.impl.c:
    java.util.Map annotators -> b
    boolean $assertionsDisabled -> a
    void annotate(org.eclipse.emf.ecore.resource.Resource) -> a
    void annotate(org.eclipse.emf.ecore.EObject) -> a
    void annotate(org.eclipse.emf.ecore.resource.Resource,java.lang.String) -> a
    void annotate(org.eclipse.emf.ecore.EObject,java.lang.String) -> a
    java.util.List annotate(org.eclipse.emf.ecore.EObject,java.util.Collection) -> a
    void removeAnnotation(org.eclipse.emf.ecore.resource.Resource,java.lang.String) -> b
    boolean hasAnnotation(java.lang.String) -> a
    void removeAllAnnotations(org.eclipse.emf.ecore.resource.Resource) -> b
org.sidiff.core.annotation.impl.DefaultAnnotationServiceImpl$1 -> org.sidiff.core.annotation.impl.a:
    org.sidiff.core.annotation.impl.DefaultAnnotationServiceImpl this$0 -> a
    java.lang.String val$annotationKey -> b
    void finish(org.eclipse.emf.ecore.EObject) -> a
    void init(org.eclipse.emf.ecore.EObject) -> b
    void postExecute(org.eclipse.emf.ecore.EObject) -> c
    boolean preExecute(org.eclipse.emf.ecore.EObject) -> d
org.sidiff.core.annotation.impl.DefaultAnnotationServiceProviderImpl -> org.sidiff.core.annotation.impl.e:
    java.util.ArrayList annotatorReferences -> b
    java.lang.String configure(java.lang.Object[]) -> a
    void deconfigure() -> b
    java.util.Dictionary getProperties() -> c
    org.sidiff.core.annotation.AnnotationService createInstance() -> d
    java.lang.Object createInstance() -> a
org.sidiff.core.annotators.Activator -> org.sidiff.core.annotators.b:
    void start(org.osgi.framework.BundleContext) -> start
    void stop(org.osgi.framework.BundleContext) -> stop
org.sidiff.core.annotators.HashAnnotator -> org.sidiff.core.annotators.a:
    java.lang.String NO_HASH_ANNOTATION_LABEL -> a
    java.lang.String HASHVALUES_PREFIX -> b
    java.lang.String DEFAULT_HASH_ALGORITHM -> c
    java.security.MessageDigest md -> d
    org.sidiff.common.collections.ValueMap hashValues -> e
    org.sidiff.core.annotators.HashAnnotator$HashingDirective hashingDirective -> f
    java.lang.String pathAnnotationKey -> g
    java.lang.String referencedHashAnnotationKey -> h
    java.lang.String childrenHashAnnotationKey -> i
    java.util.ArrayList excludes -> j
    boolean isIgnored(java.lang.String) -> a
    void init(org.eclipse.emf.ecore.EObject) -> b
    void finish(org.eclipse.emf.ecore.EObject) -> a
    java.lang.Object computeAnnotationValue(org.eclipse.emf.ecore.EObject) -> e
    java.lang.String getCurrentHashValue() -> a
    void hashAttributes(org.eclipse.emf.ecore.EObject) -> f
    void hashReferencedObjects(org.eclipse.emf.ecore.EObject,java.util.List,java.lang.String) -> a
org.sidiff.core.annotators.HashAnnotator$HashingDirective -> org.sidiff.core.annotators.f:
    org.sidiff.core.annotators.HashAnnotator$HashingDirective UnorderedHashing -> a
    org.sidiff.core.annotators.HashAnnotator$HashingDirective OrderedHashing -> b
    org.sidiff.core.annotators.HashAnnotator$HashingDirective UnorderedHashingMoveAllowed -> c
    org.sidiff.core.annotators.HashAnnotator$HashingDirective OrderedHashingMoveAllowed -> d
    org.sidiff.core.annotators.HashAnnotator$HashingDirective[] ENUM$VALUES -> e
    org.sidiff.core.annotators.HashAnnotator$HashingDirective[] values() -> values
    org.sidiff.core.annotators.HashAnnotator$HashingDirective valueOf(java.lang.String) -> valueOf
org.sidiff.core.annotators.MappedPathAnnotator -> org.sidiff.core.annotators.g:
    java.lang.Object computeAnnotationValue(org.eclipse.emf.ecore.EObject) -> e
org.sidiff.core.annotators.PathAnnotator -> org.sidiff.core.annotators.c:
    java.lang.String PATH_ATTRIBUTE_ANNOTATION_LABEL -> a
    java.lang.String PATH_DELIMITER -> b
    java.util.HashMap pathAttributes -> c
    void init(org.eclipse.emf.ecore.EObject) -> b
    java.lang.Object computeAnnotationValue(org.eclipse.emf.ecore.EObject) -> e
org.sidiff.core.annotators.SetAttributeAnnotator -> org.sidiff.core.annotators.e:
    java.lang.String SET -> a
    java.lang.String COPY -> b
    java.lang.String MOVE -> c
    java.lang.String CREATE -> d
    java.lang.Object computeAnnotationValue(org.eclipse.emf.ecore.EObject) -> e
org.sidiff.core.annotators.TypePathAnnotator -> org.sidiff.core.annotators.d:
    java.lang.Object computeAnnotationValue(org.eclipse.emf.ecore.EObject) -> e
org.sidiff.core.candidates.CandidatesDebugger -> org.sidiff.core.candidates.c:
    java.lang.String candidates(org.sidiff.core.candidates.CandidatesService,org.eclipse.emf.ecore.EObject) -> a
    java.lang.String candidates(org.sidiff.core.candidates.CandidatesService,org.eclipse.emf.ecore.resource.Resource) -> a
org.sidiff.core.candidates.CandidatesService -> org.sidiff.core.candidates.CandidatesService:
    boolean isCandidate(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject[]) -> a
    boolean hasCandidates(org.eclipse.emf.ecore.EObject) -> b
    java.util.List getCandidates(org.eclipse.emf.ecore.EObject) -> a
org.sidiff.core.candidates.CandidatesServiceProvider -> org.sidiff.core.candidates.CandidatesServiceProvider:
org.sidiff.core.candidates.CompositeCandidatesService -> org.sidiff.core.candidates.b:
    boolean initialized -> b
    org.sidiff.core.candidates.CompositeCandidatesService$IntersectionPolicy policy -> c
    java.util.List services -> d
    int[] $SWITCH_TABLE$org$sidiff$core$candidates$CompositeCandidatesService$IntersectionPolicy -> e
    boolean $assertionsDisabled -> a
    java.util.List getCandidates(org.eclipse.emf.ecore.EObject) -> a
    boolean hasCandidates(org.eclipse.emf.ecore.EObject) -> b
    boolean isCandidate(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject[]) -> a
    void initialize(org.sidiff.common.services.ServiceContext,java.lang.Object[]) -> a
    void addCandidatesService(org.sidiff.core.candidates.CandidatesService) -> a
    void removeCandidatesService(org.sidiff.core.candidates.CandidatesService) -> b
    int[] $SWITCH_TABLE$org$sidiff$core$candidates$CompositeCandidatesService$IntersectionPolicy() -> a
org.sidiff.core.candidates.CompositeCandidatesService$IntersectionPolicy -> org.sidiff.core.candidates.a:
    org.sidiff.core.candidates.CompositeCandidatesService$IntersectionPolicy UNION -> a
    org.sidiff.core.candidates.CompositeCandidatesService$IntersectionPolicy INTERSECTION -> b
    org.sidiff.core.candidates.CompositeCandidatesService$IntersectionPolicy[] ENUM$VALUES -> c
    org.sidiff.core.candidates.CompositeCandidatesService$IntersectionPolicy[] values() -> values
    org.sidiff.core.candidates.CompositeCandidatesService$IntersectionPolicy valueOf(java.lang.String) -> valueOf
org.sidiff.core.candidates.tree.CandidatesTreeService -> org.sidiff.core.candidates.tree.CandidatesTreeService:
org.sidiff.core.candidates.tree.CandidatesTreeServiceProvider -> org.sidiff.core.candidates.tree.CandidatesTreeServiceProvider:
org.sidiff.core.candidates.tree.impl.Activator -> org.sidiff.core.candidates.tree.impl.b:
    void start(org.osgi.framework.BundleContext) -> start
    void stop(org.osgi.framework.BundleContext) -> stop
org.sidiff.core.candidates.tree.impl.CandidatesTreeServiceImpl -> org.sidiff.core.candidates.tree.impl.c:
    org.sidiff.core.correspondences.CorrespondencesService correspondences -> d
    org.eclipse.emf.ecore.resource.Resource modelA -> e
    org.eclipse.emf.ecore.resource.Resource modelB -> f
    java.util.Map map1 -> a
    java.util.Map map2 -> b
    boolean $assertionsDisabled -> c
    void initialize(org.sidiff.common.services.ServiceContext,java.lang.Object[]) -> a
    void eventDispatched(org.sidiff.common.services.events.SCEvent) -> a
    java.util.List getCandidates(org.eclipse.emf.ecore.EObject) -> a
    boolean hasCandidates(org.eclipse.emf.ecore.EObject) -> b
    boolean isCandidate(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject[]) -> a
org.sidiff.core.candidates.tree.impl.CandidatesTreeServiceProviderImpl -> org.sidiff.core.candidates.tree.impl.a:
    java.lang.String configure(java.lang.Object[]) -> a
    void deconfigure() -> b
    java.util.Dictionary getProperties() -> c
    java.lang.Object createInstance() -> a
org.sidiff.core.compare.calculator.DefaultSimilaritiesCalculationService -> org.sidiff.core.compare.calculator.DefaultSimilaritiesCalculationService:
org.sidiff.core.compare.calculator.DefaultSimilaritiesCalculationServiceProvider -> org.sidiff.core.compare.calculator.DefaultSimilaritiesCalculationServiceProvider:
org.sidiff.core.compare.calculator.SimilaritiesCalculationService -> org.sidiff.core.compare.calculator.SimilaritiesCalculationService:
    void calculateSimilarities(java.lang.Iterable) -> a
    void calculateSimilarities(org.eclipse.emf.ecore.EObject[]) -> a
org.sidiff.core.compare.calculator.SimilaritiesCalculationServiceProvider -> org.sidiff.core.compare.calculator.SimilaritiesCalculationServiceProvider:
org.sidiff.core.compare.calculator.SimilarityCalculationEvent -> org.sidiff.core.compare.calculator.a:
    long serialVersionUID -> k
    int START_COMPARISON -> a
    int STOP_COMPARISON -> b
    int START_COMPAREFUNCTION -> c
    int STOP_COMPAREFUNCTION -> d
    int COMPARISON_ELEMENT_A_FEATURE -> e
    int COMPARISON_ELEMENT_B_FEATURE -> f
    int COMPARISON_SIMILARITY_VALUE -> g
    int COMPAREFUNCTION_FEATURE -> h
    int RESULT_FEATURE -> i
org.sidiff.core.compare.calculator.configuration.CompareConfiguration -> org.sidiff.core.compare.calculator.configuration.a:
    org.eclipse.emf.ecore.EPackage ePackage -> b
    boolean normalizeWeights -> c
    org.sidiff.common.emf.EMFMetaObjectExtender typeConfigurations -> d
    boolean $assertionsDisabled -> a
    org.sidiff.core.compare.calculator.configuration.TypeConfiguration getTypeConfiguration(org.eclipse.emf.ecore.EClass) -> a
    org.sidiff.core.compare.calculator.configuration.TypeConfiguration addTypeConfiguration(org.sidiff.core.compare.calculator.configuration.TypeConfiguration) -> a
    org.eclipse.emf.ecore.EPackage getConfiguredEPackage() -> a
    boolean isNormalizeWeights() -> b
    void setNormalizeWeights(boolean) -> a
    void initialize(org.sidiff.common.services.ServiceContext) -> a
org.sidiff.core.compare.calculator.configuration.ConfigurationHandler -> org.sidiff.core.compare.calculator.configuration.ConfigurationHandler:
    org.sidiff.core.compare.calculator.configuration.CompareConfiguration parseConfiguration(java.lang.Object) -> a
org.sidiff.core.compare.calculator.configuration.TypeConfiguration -> org.sidiff.core.compare.calculator.configuration.c:
    org.eclipse.emf.ecore.EClass eClass -> c
    float threshold -> d
    java.util.List rwCompareFunctions -> a
    java.util.List roCompareFunctions -> b
    org.eclipse.emf.ecore.EClass getType() -> a
    float getThreshold() -> b
    boolean addCompareFunction(org.sidiff.core.compare.comparefunctions.CompareFunction) -> a
    java.util.List getCompareFunctions() -> c
    java.lang.String toString() -> toString
    void initialize(org.sidiff.common.services.ServiceContext) -> a
org.sidiff.core.compare.calculator.configuration.XMLConfigurationHandler -> org.sidiff.core.compare.calculator.configuration.b:
    java.lang.String ATT_SETTINGS_CFPREFIX_CONST_DEFAULT -> a
    java.lang.String ATT_SETTINGS_CONDPREFIX_CONST_DEFAULT -> b
    java.lang.String ATT_COMPAREFUNCTION_POLICY_CONST_DEFAULT -> c
    java.lang.String ELEM_SETTINGS -> d
    java.lang.String ATT_SETTINGS_CFPREFIX -> e
    java.lang.String ATT_SETTINGS_CONDPREFIX -> f
    java.lang.String ATT_SETTINGS_NORMWEIGHTS -> g
    java.lang.String ATT_SETTINGS_DOCTYPE -> h
    java.lang.String ELEM_CLASS -> i
    java.lang.String ATT_CLASS_NAME -> j
    java.lang.String ATT_CLASS_THRESHOLD -> k
    java.lang.String ELEM_COMPAREFUNCTION -> l
    java.lang.String ATT_COMPAREFUNCTION_CLASS -> m
    java.lang.String ATT_COMPAREFUNCTION_WEIGHT -> n
    java.lang.String ATT_COMPAREFUNCTION_PARAMETER -> o
    java.lang.String ATT_COMPAREFUNCTION_POLICY -> p
    java.lang.String ELEM_IF -> q
    java.lang.String ATT_IF_CONDITION -> r
    java.lang.String ATT_IF_WEIGHT -> s
    java.lang.String ATT_IF_PARAMETER -> t
    java.lang.String ATT_IF_IFPOLICY -> u
    java.lang.String ATT_IF_CONDITIONPOLICY -> v
    java.lang.String ELEM_THEN -> w
    java.lang.String ELEM_ELSE -> x
    java.lang.String comparefunctionPrefix -> y
    java.lang.String conditionPrefix -> z
    org.sidiff.core.compare.calculator.configuration.CompareConfiguration parseConfiguration(org.w3c.dom.Document) -> a
    org.sidiff.core.compare.calculator.configuration.CompareConfiguration processSettings(org.w3c.dom.Node) -> a
    org.sidiff.core.compare.calculator.configuration.TypeConfiguration createTypeConfiguration(org.eclipse.emf.ecore.EPackage,org.w3c.dom.Node) -> a
    java.util.Collection getCompareFunctions(org.eclipse.emf.ecore.EClass,org.w3c.dom.NodeList) -> a
    org.sidiff.core.compare.comparefunctions.CompareFunction createcCompareFunction(org.eclipse.emf.ecore.EClass,org.w3c.dom.Node) -> a
    org.sidiff.core.compare.comparefunctions.CompareFunction createIf(org.eclipse.emf.ecore.EClass,org.w3c.dom.Node) -> b
    java.lang.String getValue(org.w3c.dom.NamedNodeMap,java.lang.String) -> a
    org.sidiff.core.compare.calculator.configuration.CompareConfiguration parseConfiguration(java.lang.Object) -> a
    java.lang.String access$1(org.sidiff.core.compare.calculator.configuration.XMLConfigurationHandler,org.w3c.dom.NamedNodeMap,java.lang.String) -> a
org.sidiff.core.compare.calculator.configuration.XMLConfigurationHandler$InvalidArgumentException -> org.sidiff.core.compare.calculator.configuration.e:
    long serialVersionUID -> b
    org.sidiff.core.compare.calculator.configuration.XMLConfigurationHandler this$0 -> a
org.sidiff.core.compare.calculator.configuration.XMLConfigurationHandler$MissingPackageException -> org.sidiff.core.compare.calculator.configuration.d:
    long serialVersionUID -> b
    org.sidiff.core.compare.calculator.configuration.XMLConfigurationHandler this$0 -> a
org.sidiff.core.compare.calculator.exceptions.DuplicateCompareItemException -> org.sidiff.core.compare.calculator.exceptions.a:
    long serialVersionUID -> a
org.sidiff.core.compare.calculator.exceptions.DuplicateDefaultNodeTypeConfiguration -> org.sidiff.core.compare.calculator.exceptions.b:
    long serialVersionUID -> a
org.sidiff.core.compare.calculator.impl.Activator -> org.sidiff.core.compare.calculator.impl.b:
    void start(org.osgi.framework.BundleContext) -> start
    void stop(org.osgi.framework.BundleContext) -> stop
org.sidiff.core.compare.calculator.impl.IfThenElse -> org.sidiff.core.compare.calculator.impl.c:
    java.util.List thenItems -> b
    java.util.List elseItems -> e
    org.sidiff.core.compare.comparefunctions.conditions.Condition condition -> f
    boolean $assertionsDisabled -> a
    float compare(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject) -> a
    void setContext(org.sidiff.common.services.ServiceContext) -> a
    void addThenItem(org.sidiff.core.compare.comparefunctions.CompareFunction) -> a
    void addElseItem(org.sidiff.core.compare.comparefunctions.CompareFunction) -> b
org.sidiff.core.compare.calculator.impl.SimilaritiesCalculationServiceImpl -> org.sidiff.core.compare.calculator.impl.a:
    org.sidiff.core.compare.calculator.configuration.CompareConfiguration configuration -> b
    org.sidiff.common.services.ServiceContext context -> c
    org.eclipse.emf.ecore.resource.Resource resourceA -> d
    org.eclipse.emf.ecore.resource.Resource resourceB -> e
    org.sidiff.core.compare.similarities.SimilaritiesService similarities -> f
    org.sidiff.core.candidates.CandidatesService candidatesService -> g
    boolean $assertionsDisabled -> a
    void initialize(org.sidiff.common.services.ServiceContext,java.lang.Object[]) -> a
    void initialize(java.lang.Object[]) -> a
    void calculateSimilarities(java.lang.Iterable) -> a
    void calculateSimilarities(org.eclipse.emf.ecore.EObject[]) -> a
    float compare(org.eclipse.emf.ecore.EObject,org.sidiff.core.compare.calculator.configuration.TypeConfiguration,org.eclipse.emf.ecore.EObject) -> a
    float[] executeCompareFunctions(org.sidiff.common.services.ServiceContext,org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject,java.util.List) -> a
org.sidiff.core.compare.calculator.impl.SimilaritiesCalculationServiceProviderImpl -> org.sidiff.core.compare.calculator.impl.d:
    org.sidiff.core.compare.calculator.configuration.ConfigurationHandler CONFIGHANDLER -> b
    org.sidiff.core.compare.calculator.configuration.CompareConfiguration compareConfiguration -> c
    java.lang.String configure(java.lang.Object[]) -> a
    void deconfigure() -> b
    java.util.Dictionary getProperties() -> c
    org.sidiff.core.compare.calculator.SimilaritiesCalculationService createInstance() -> d
    java.lang.Object createInstance() -> a
org.sidiff.core.compare.comparefunction.conditions.EqualAnnotationValueCondition -> org.sidiff.core.compare.comparefunction.conditions.b:
    boolean $assertionsDisabled -> a
    void init(org.sidiff.common.services.ServiceContext) -> a
    boolean check(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject) -> a
org.sidiff.core.compare.comparefunction.conditions.FixedAnnotationValueCondition -> org.sidiff.core.compare.comparefunction.conditions.a:
    java.lang.Object objectOfComparison -> b
    boolean $assertionsDisabled -> a
    void init(org.sidiff.common.services.ServiceContext) -> a
    boolean check(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject) -> a
org.sidiff.core.compare.comparefunctions.ChildrenCF -> org.sidiff.core.compare.comparefunctions.e:
    org.sidiff.core.compare.comparefunctions.abstractcomparators.AbstractComparator cfComparator -> b
    boolean $assertionsDisabled -> a
    void setContext(org.sidiff.common.services.ServiceContext) -> a
    float compare(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject) -> a
org.sidiff.core.compare.comparefunctions.CompareFunction -> org.sidiff.core.compare.comparefunctions.l:
    org.sidiff.core.compare.comparefunctions.CompareFunction$Policy policy -> a
    float weight -> b
    org.eclipse.emf.ecore.EClass dedicatedClass -> e
    java.lang.String[] paramItems -> c
    org.sidiff.common.services.ServiceContext context -> d
    org.sidiff.core.compare.comparefunctions.CompareFunction$Policy getPolicy() -> a
    float getWeight() -> b
    org.eclipse.emf.ecore.EClass getEClass() -> c
    void setContext(org.sidiff.common.services.ServiceContext) -> a
    float compare(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject) -> a
    java.lang.String getSignature() -> d
org.sidiff.core.compare.comparefunctions.CompareFunction$Policy -> org.sidiff.core.compare.comparefunctions.c:
    org.sidiff.core.compare.comparefunctions.CompareFunction$Policy mandatory -> a
    org.sidiff.core.compare.comparefunctions.CompareFunction$Policy fulfilled -> b
    org.sidiff.core.compare.comparefunctions.CompareFunction$Policy unfulfilled -> c
    org.sidiff.core.compare.comparefunctions.CompareFunction$Policy[] ENUM$VALUES -> d
    org.sidiff.core.compare.comparefunctions.CompareFunction$Policy[] values() -> values
    org.sidiff.core.compare.comparefunctions.CompareFunction$Policy valueOf(java.lang.String) -> valueOf
org.sidiff.core.compare.comparefunctions.MaximumSimilarityCF -> org.sidiff.core.compare.comparefunctions.h:
    boolean $assertionsDisabled -> a
    float compare(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject) -> a
org.sidiff.core.compare.comparefunctions.MinimumSimilarityCF -> org.sidiff.core.compare.comparefunctions.j:
    boolean $assertionsDisabled -> a
    float compare(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject) -> a
org.sidiff.core.compare.comparefunctions.NeighboursMultipleReferenceCF -> org.sidiff.core.compare.comparefunctions.k:
    java.util.List referenceList -> a
    org.sidiff.core.compare.comparefunctions.abstractcomparators.AbstractComparator cfComparator -> e
    boolean $assertionsDisabled -> b
    void setContext(org.sidiff.common.services.ServiceContext) -> a
    float compare(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject) -> a
org.sidiff.core.compare.comparefunctions.NeighboursSingleReferenceCF -> org.sidiff.core.compare.comparefunctions.b:
    org.eclipse.emf.ecore.EReference reference -> a
    org.sidiff.core.compare.comparefunctions.abstractcomparators.AbstractComparator cfComparator -> e
    boolean $assertionsDisabled -> b
    void setContext(org.sidiff.common.services.ServiceContext) -> a
    float compare(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject) -> a
org.sidiff.core.compare.comparefunctions.ParentCF -> org.sidiff.core.compare.comparefunctions.a:
    org.sidiff.core.compare.comparefunctions.abstractcomparators.AbstractComparator cfComparator -> b
    boolean $assertionsDisabled -> a
    void setContext(org.sidiff.common.services.ServiceContext) -> a
    float compare(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject) -> a
org.sidiff.core.compare.comparefunctions.RemoteNodesCF -> org.sidiff.core.compare.comparefunctions.i:
    org.sidiff.common.emf.access.EMFPath path -> a
    org.sidiff.core.compare.comparefunctions.abstractcomparators.AbstractComparator cfComparator -> e
    boolean $assertionsDisabled -> b
    void setContext(org.sidiff.common.services.ServiceContext) -> a
    float compare(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject) -> a
org.sidiff.core.compare.comparefunctions.SelfCF -> org.sidiff.core.compare.comparefunctions.g:
    org.sidiff.core.compare.comparefunctions.abstractcomparators.AbstractComparator cfComparator -> b
    boolean $assertionsDisabled -> a
    void setContext(org.sidiff.common.services.ServiceContext) -> a
    float compare(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject) -> a
org.sidiff.core.compare.comparefunctions.ShouldNotOccurDummy -> org.sidiff.core.compare.comparefunctions.d:
    float compare(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject) -> a
    java.lang.String toString() -> toString
org.sidiff.core.compare.comparefunctions.SingleNeighbourCF -> org.sidiff.core.compare.comparefunctions.f:
    org.eclipse.emf.ecore.EReference reference -> a
    org.sidiff.core.compare.comparefunctions.abstractcomparators.AbstractComparator cfComparator -> e
    boolean $assertionsDisabled -> b
    void setContext(org.sidiff.common.services.ServiceContext) -> a
    float compare(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject) -> a
org.sidiff.core.compare.comparefunctions.abstractcomparators.AbstractCollectionComparator -> org.sidiff.core.compare.comparefunctions.abstractcomparators.a:
org.sidiff.core.compare.comparefunctions.abstractcomparators.AbstractComparator -> org.sidiff.core.compare.comparefunctions.abstractcomparators.f:
    java.lang.String[] paramItems -> c
    org.eclipse.emf.ecore.EClass eClass -> d
    void init(org.sidiff.common.services.ServiceContext) -> a
    float compare(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject,java.lang.Object,java.lang.Object) -> a
    java.lang.Object loadComparator(java.lang.String,org.eclipse.emf.ecore.EClass,java.lang.Class) -> a
org.sidiff.core.compare.comparefunctions.abstractcomparators.AbstractElementComparator -> org.sidiff.core.compare.comparefunctions.abstractcomparators.b:
    boolean $assertionsDisabled -> b
    float compare(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject,java.lang.Object,java.lang.Object) -> a
    float compare(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject) -> a
org.sidiff.core.compare.comparefunctions.abstractcomparators.AbstractListComparator -> org.sidiff.core.compare.comparefunctions.abstractcomparators.d:
    boolean $assertionsDisabled -> b
    float compare(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject,java.lang.Object,java.lang.Object) -> a
    float compare(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject,java.util.List,java.util.List) -> a
org.sidiff.core.compare.comparefunctions.abstractcomparators.AbstractSetComparator -> org.sidiff.core.compare.comparefunctions.abstractcomparators.c:
    boolean $assertionsDisabled -> a
    float compare(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject,java.lang.Object,java.lang.Object) -> a
    float compare(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject,java.util.Collection,java.util.Collection) -> a
org.sidiff.core.compare.comparefunctions.abstractcomparators.AbstractSingleComparator -> org.sidiff.core.compare.comparefunctions.abstractcomparators.g:
org.sidiff.core.compare.comparefunctions.abstractcomparators.AbstractValueComparator -> org.sidiff.core.compare.comparefunctions.abstractcomparators.e:
org.sidiff.core.compare.comparefunctions.activator.Activator -> org.sidiff.core.compare.comparefunctions.activator.a:
    void start(org.osgi.framework.BundleContext) -> start
    void stop(org.osgi.framework.BundleContext) -> stop
org.sidiff.core.compare.comparefunctions.comparators.CEStringToStringMapEntry -> org.sidiff.core.compare.comparefunctions.comparators.j:
    org.sidiff.core.compare.comparefunctions.abstractcomparators.AbstractValueComparator comparator -> b
    boolean $assertionsDisabled -> a
    void init(org.sidiff.common.services.ServiceContext) -> a
    float compare(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject,java.lang.Object,java.lang.Object) -> a
org.sidiff.core.compare.comparefunctions.comparators.CEqualType -> org.sidiff.core.compare.comparefunctions.comparators.d:
    void init(org.sidiff.common.services.ServiceContext) -> a
    float compare(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject,java.lang.Object,java.lang.Object) -> a
org.sidiff.core.compare.comparefunctions.comparators.CEquals -> org.sidiff.core.compare.comparefunctions.comparators.c:
    void init(org.sidiff.common.services.ServiceContext) -> a
    float compare(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject,java.lang.Object,java.lang.Object) -> a
org.sidiff.core.compare.comparefunctions.comparators.CHeaviside -> org.sidiff.core.compare.comparefunctions.comparators.n:
    org.sidiff.core.compare.comparefunctions.abstractcomparators.AbstractComparator comparator -> a
    float threshold -> b
    void init(org.sidiff.common.services.ServiceContext) -> a
    float compare(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject,java.lang.Object,java.lang.Object) -> a
org.sidiff.core.compare.comparefunctions.comparators.CHeavisideReverse -> org.sidiff.core.compare.comparefunctions.comparators.v:
    org.sidiff.core.compare.comparefunctions.abstractcomparators.AbstractComparator comparator -> a
    float threshold -> b
    void init(org.sidiff.common.services.ServiceContext) -> a
    float compare(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject,java.lang.Object,java.lang.Object) -> a
org.sidiff.core.compare.comparefunctions.comparators.ECAnnotation -> org.sidiff.core.compare.comparefunctions.comparators.e:
    org.sidiff.core.compare.comparefunctions.abstractcomparators.AbstractValueComparator comparator -> e
    java.lang.String annotationName -> f
    boolean $assertionsDisabled -> a
    void init(org.sidiff.common.services.ServiceContext) -> a
    float compare(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject) -> a
org.sidiff.core.compare.comparefunctions.comparators.ECAttributeDynamic -> org.sidiff.core.compare.comparefunctions.comparators.r:
    org.sidiff.core.compare.comparefunctions.abstractcomparators.AbstractValueComparator comparator -> a
    java.lang.String attributeName -> e
    void init(org.sidiff.common.services.ServiceContext) -> a
    float compare(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject) -> a
org.sidiff.core.compare.comparefunctions.comparators.ECAttributeStatic -> org.sidiff.core.compare.comparefunctions.comparators.u:
    org.sidiff.core.compare.comparefunctions.abstractcomparators.AbstractValueComparator comparator -> a
    org.eclipse.emf.ecore.EAttribute attribute -> e
    void init(org.sidiff.common.services.ServiceContext) -> a
    float compare(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject) -> a
org.sidiff.core.compare.comparefunctions.comparators.ECEqualIndex -> org.sidiff.core.compare.comparefunctions.comparators.h:
    void init(org.sidiff.common.services.ServiceContext) -> a
    float compare(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject) -> a
org.sidiff.core.compare.comparefunctions.comparators.ECMatched -> org.sidiff.core.compare.comparefunctions.comparators.q:
    org.sidiff.core.correspondences.CorrespondencesService correspondencesService -> a
    org.sidiff.common.services.ServiceContext serviceContext -> e
    int[] $SWITCH_TABLE$org$sidiff$common$emf$access$ExternalObjectComparison -> f
    void init(org.sidiff.common.services.ServiceContext) -> a
    float compare(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject) -> a
    int[] $SWITCH_TABLE$org$sidiff$common$emf$access$ExternalObjectComparison() -> a
org.sidiff.core.compare.comparefunctions.comparators.ECMatchedOrSimilar -> org.sidiff.core.compare.comparefunctions.comparators.f:
    org.sidiff.core.compare.similarities.SimilaritiesService similaritiesService -> a
    org.sidiff.core.correspondences.CorrespondencesService correspondencesService -> e
    org.sidiff.common.services.ServiceContext serviceContext -> f
    void init(org.sidiff.common.services.ServiceContext) -> a
    float compare(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject) -> a
org.sidiff.core.compare.comparefunctions.comparators.ECSimilarity -> org.sidiff.core.compare.comparefunctions.comparators.l:
    org.sidiff.core.compare.similarities.SimilaritiesService similaritiesService -> a
    void init(org.sidiff.common.services.ServiceContext) -> a
    float compare(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject) -> a
org.sidiff.core.compare.comparefunctions.comparators.LCAlignedList -> org.sidiff.core.compare.comparefunctions.comparators.g:
    org.sidiff.core.compare.comparefunctions.abstractcomparators.AbstractSingleComparator comparator -> e
    boolean $assertionsDisabled -> a
    void init(org.sidiff.common.services.ServiceContext) -> a
    float compare(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject,java.util.List,java.util.List) -> a
org.sidiff.core.compare.comparefunctions.comparators.LCLongestCommonSubsequence -> org.sidiff.core.compare.comparefunctions.comparators.w:
    org.sidiff.core.compare.comparefunctions.abstractcomparators.AbstractSingleComparator comparator -> a
    float threshold -> e
    void init(org.sidiff.common.services.ServiceContext) -> a
    float compare(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject,java.util.List,java.util.List) -> a
org.sidiff.core.compare.comparefunctions.comparators.SCGreedyMatchedOrSimilar -> org.sidiff.core.compare.comparefunctions.comparators.i:
    org.sidiff.core.compare.similarities.SimilaritiesService similaritiesService -> b
    org.sidiff.core.correspondences.CorrespondencesService correspondencesService -> e
    org.sidiff.common.services.ServiceContext serviceContext -> f
    void init(org.sidiff.common.services.ServiceContext) -> a
    float compare(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject,java.util.Collection,java.util.Collection) -> a
org.sidiff.core.compare.comparefunctions.comparators.SCGreedySimilarity -> org.sidiff.core.compare.comparefunctions.comparators.s:
    org.sidiff.core.compare.similarities.SimilaritiesService similaritiesService -> b
    void init(org.sidiff.common.services.ServiceContext) -> a
    float compare(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject,java.util.Collection,java.util.Collection) -> a
org.sidiff.core.compare.comparefunctions.comparators.SCMatched -> org.sidiff.core.compare.comparefunctions.comparators.p:
    org.sidiff.core.correspondences.CorrespondencesService correspondencesService -> e
    org.sidiff.common.services.ServiceContext serviceContext -> f
    boolean $assertionsDisabled -> b
    void init(org.sidiff.common.services.ServiceContext) -> a
    float compare(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject,java.util.Collection,java.util.Collection) -> a
org.sidiff.core.compare.comparefunctions.comparators.SCSize -> org.sidiff.core.compare.comparefunctions.comparators.m:
    void init(org.sidiff.common.services.ServiceContext) -> a
    float compare(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject,java.util.Collection,java.util.Collection) -> a
org.sidiff.core.compare.comparefunctions.comparators.VCCharacterEqualsCI -> org.sidiff.core.compare.comparefunctions.comparators.t:
    boolean $assertionsDisabled -> a
    float compare(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject,java.lang.Object,java.lang.Object) -> a
    void init(org.sidiff.common.services.ServiceContext) -> a
org.sidiff.core.compare.comparefunctions.comparators.VCGauss -> org.sidiff.core.compare.comparefunctions.comparators.x:
    float scale -> b
    boolean $assertionsDisabled -> a
    void init(org.sidiff.common.services.ServiceContext) -> a
    float compare(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject,java.lang.Object,java.lang.Object) -> a
org.sidiff.core.compare.comparefunctions.comparators.VCStringEMFCompare -> org.sidiff.core.compare.comparefunctions.comparators.a:
    boolean ci -> b
    boolean $assertionsDisabled -> a
    java.util.List pairs(java.lang.String) -> a
    float emfNameComparison(java.lang.String,java.lang.String) -> a
    float compare(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject,java.lang.Object,java.lang.Object) -> a
    void init(org.sidiff.common.services.ServiceContext) -> a
org.sidiff.core.compare.comparefunctions.comparators.VCStringEqualsCI -> org.sidiff.core.compare.comparefunctions.comparators.k:
    boolean $assertionsDisabled -> a
    float compare(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject,java.lang.Object,java.lang.Object) -> a
    void init(org.sidiff.common.services.ServiceContext) -> a
org.sidiff.core.compare.comparefunctions.comparators.VCStringIndexOf -> org.sidiff.core.compare.comparefunctions.comparators.o:
    boolean ci -> b
    boolean $assertionsDisabled -> a
    float compare(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject,java.lang.Object,java.lang.Object) -> a
    void init(org.sidiff.common.services.ServiceContext) -> a
org.sidiff.core.compare.comparefunctions.comparators.VCStringLCS -> org.sidiff.core.compare.comparefunctions.comparators.b:
    boolean ci -> b
    boolean $assertionsDisabled -> a
    void init(org.sidiff.common.services.ServiceContext) -> a
    float compare(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject,java.lang.Object,java.lang.Object) -> a
org.sidiff.core.compare.comparefunctions.conditions.CompareFunctionCondition -> org.sidiff.core.compare.comparefunctions.conditions.b:
    org.sidiff.core.compare.comparefunctions.CompareFunction conditionCF -> b
    float threshold -> c
    boolean $assertionsDisabled -> a
    void init(org.sidiff.common.services.ServiceContext) -> a
    boolean check(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject) -> a
org.sidiff.core.compare.comparefunctions.conditions.Condition -> org.sidiff.core.compare.comparefunctions.conditions.f:
    org.sidiff.core.compare.comparefunctions.CompareFunction$Policy policy -> a
    org.eclipse.emf.ecore.EClass dedicatedClass -> b
    java.lang.String parameter -> c
    java.lang.String getParameter() -> a
    org.eclipse.emf.ecore.EClass getEClass() -> b
    org.sidiff.core.compare.comparefunctions.CompareFunction$Policy getPolicy() -> c
    void init(org.sidiff.common.services.ServiceContext) -> a
    boolean check(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject) -> a
org.sidiff.core.compare.comparefunctions.conditions.EqualAttributeValueCondition -> org.sidiff.core.compare.comparefunctions.conditions.h:
    org.eclipse.emf.ecore.EAttribute attribute -> b
    boolean $assertionsDisabled -> a
    void init(org.sidiff.common.services.ServiceContext) -> a
    boolean check(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject) -> a
org.sidiff.core.compare.comparefunctions.conditions.FalseCondition -> org.sidiff.core.compare.comparefunctions.conditions.d:
    void init(org.sidiff.common.services.ServiceContext) -> a
    boolean check(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject) -> a
org.sidiff.core.compare.comparefunctions.conditions.FixedAttributeValueCondition -> org.sidiff.core.compare.comparefunctions.conditions.c:
    java.lang.Object attributeValue -> b
    org.eclipse.emf.ecore.EAttribute attribute -> c
    boolean $assertionsDisabled -> a
    void init(org.sidiff.common.services.ServiceContext) -> a
    boolean check(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject) -> a
org.sidiff.core.compare.comparefunctions.conditions.NoChildrenCondition -> org.sidiff.core.compare.comparefunctions.conditions.g:
    boolean $assertionsDisabled -> a
    void init(org.sidiff.common.services.ServiceContext) -> a
    boolean check(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject) -> a
org.sidiff.core.compare.comparefunctions.conditions.ParentMatchedCondition -> org.sidiff.core.compare.comparefunctions.conditions.a:
    org.sidiff.core.correspondences.CorrespondencesService correspondencesService -> b
    boolean $assertionsDisabled -> a
    void init(org.sidiff.common.services.ServiceContext) -> a
    boolean check(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject) -> a
org.sidiff.core.compare.comparefunctions.conditions.TrueCondition -> org.sidiff.core.compare.comparefunctions.conditions.e:
    void init(org.sidiff.common.services.ServiceContext) -> a
    boolean check(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject) -> a
org.sidiff.core.compare.comparefunctions.emf.Activator -> org.sidiff.core.compare.comparefunctions.emf.a:
    void start(org.osgi.framework.BundleContext) -> start
    void stop(org.osgi.framework.BundleContext) -> stop
org.sidiff.core.compare.comparefunctions.emf.annotations.Activator -> org.sidiff.core.compare.comparefunctions.emf.annotations.a:
    void start(org.osgi.framework.BundleContext) -> start
    void stop(org.osgi.framework.BundleContext) -> stop
org.sidiff.core.compare.comparefunctions.emf.correspondence.Activator -> org.sidiff.core.compare.comparefunctions.emf.correspondence.b:
    void start(org.osgi.framework.BundleContext) -> start
    void stop(org.osgi.framework.BundleContext) -> stop
org.sidiff.core.compare.comparefunctions.emf.correspondence.MatchInformationUsedEvent -> org.sidiff.core.compare.comparefunctions.emf.correspondence.a:
    long serialVersionUID -> d
    int USED_MATCH -> a
    int USED_ELEMENT_A_FEATURE -> b
    int USED_ELEMENT_B_FEATURE -> c
org.sidiff.core.compare.comparefunctions.emf.correspondenceandsimilarity.Activator -> org.sidiff.core.compare.comparefunctions.emf.correspondenceandsimilarity.a:
    void start(org.osgi.framework.BundleContext) -> start
    void stop(org.osgi.framework.BundleContext) -> stop
org.sidiff.core.compare.comparefunctions.emf.similarity.Activator -> org.sidiff.core.compare.comparefunctions.emf.similarity.a:
    void start(org.osgi.framework.BundleContext) -> start
    void stop(org.osgi.framework.BundleContext) -> stop
org.sidiff.core.compare.comparefunctions.exceptions.AttributeNotExistsException -> org.sidiff.core.compare.comparefunctions.exceptions.d:
    long serialVersionUID -> a
org.sidiff.core.compare.comparefunctions.exceptions.CannotInstantiateComparatorException -> org.sidiff.core.compare.comparefunctions.exceptions.e:
    long serialVersionUID -> a
org.sidiff.core.compare.comparefunctions.exceptions.CompareException -> org.sidiff.core.compare.comparefunctions.exceptions.c:
    long serialVersionUID -> a
org.sidiff.core.compare.comparefunctions.exceptions.NoValidReferencesException -> org.sidiff.core.compare.comparefunctions.exceptions.a:
    long serialVersionUID -> a
org.sidiff.core.compare.comparefunctions.exceptions.NothingToCompareException -> org.sidiff.core.compare.comparefunctions.exceptions.b:
    long serialVersionUID -> a
org.sidiff.core.compare.comparefunctions.util.ConstantValues -> org.sidiff.core.compare.comparefunctions.util.b:
    java.lang.String PARAM_SEPARATOR -> a
    java.lang.String PARAM_NESTING_OPEN -> b
    java.lang.String PARAM_NESTING_CLOSE -> c
    java.lang.String PARAM_REGEXP_NEG -> d
    java.lang.String PARAM_REGEXP_POS -> e
    java.lang.String PARAM_CASE_IGNORE -> f
    java.lang.String PARAM_CASE_SENSITIVE -> g
    java.lang.String PARAM_ORDER_AUTO -> h
    java.lang.String PARAM_ORDER_IO -> i
    java.lang.String PARAM_ORDER_CO -> j
    java.lang.String PARAM_ALL_REFERENCES -> k
    java.lang.String PARAM_LOCAL_REFERENCES -> l
    java.lang.String PARAM_HEAVISIDE_TRUE -> m
    java.lang.String PARAM_HEAVISIDE_FALSE -> n
    java.lang.String COMPARATOR_NAMESPACE -> o
org.sidiff.core.compare.comparefunctions.util.DebugCompareLogger -> org.sidiff.core.compare.comparefunctions.util.a:
    void logNewCompare(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject) -> a
    void logNewCompare(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject,java.lang.String) -> a
    void logEndCompare(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject,float) -> a
    void logMatch(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject) -> b
    void logWrongMatch(org.eclipse.emf.ecore.EObject) -> a
    void logNoMatch(org.eclipse.emf.ecore.EObject) -> b
    void logNoMatch(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject) -> c
    void logSimilarity(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject,float) -> b
    void logNoSimilarity(org.eclipse.emf.ecore.EObject) -> c
    void logEqualAnnotation(java.lang.String,org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject) -> a
    void logNoEqualAnnotation(java.lang.String,org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject) -> b
    void logNoEqualAnnotation(java.lang.String,org.eclipse.emf.ecore.EObject) -> a
    void logEqualType(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject) -> d
    void logNoEqualType(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject) -> e
    void logNoEqualType(org.eclipse.emf.ecore.EObject) -> d
    java.lang.String getSeparator() -> a
org.sidiff.core.compare.similarities.SimilaritiesDebugger -> org.sidiff.core.compare.similarities.a:
    java.lang.String similarities(org.sidiff.core.compare.similarities.SimilaritiesService,org.eclipse.emf.ecore.EObject) -> a
    java.lang.String similarities(org.sidiff.core.compare.similarities.SimilaritiesService,org.eclipse.emf.ecore.resource.Resource) -> a
org.sidiff.core.compare.similarities.SimilaritiesService -> org.sidiff.core.compare.similarities.SimilaritiesService:
    void setSimilarity(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject,float) -> a
    void dispose(org.eclipse.emf.ecore.EObject) -> a
    java.util.SortedSet getSimilarities(org.eclipse.emf.ecore.EObject) -> b
    float getSimilarityDegree(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject) -> a
org.sidiff.core.compare.similarities.SimilaritiesServiceProvider -> org.sidiff.core.compare.similarities.SimilaritiesServiceProvider:
org.sidiff.core.compare.similarities.Similarity -> org.sidiff.core.compare.similarities.Similarity:
    org.eclipse.emf.ecore.EObject getSimilarObject() -> a
    float getSimilarity() -> b
org.sidiff.core.compare.similarities.impl.Activator -> org.sidiff.core.compare.similarities.impl.e:
    void start(org.osgi.framework.BundleContext) -> start
    void stop(org.osgi.framework.BundleContext) -> stop
org.sidiff.core.compare.similarities.impl.AdaptedCollection -> org.sidiff.core.compare.similarities.impl.f:
    org.sidiff.core.compare.similarities.impl.ContentAdapter contentAdapter -> a
    java.util.Collection adaptableCollection -> b
    boolean $assertionsDisabled -> c
    boolean add(java.lang.Object) -> add
    boolean addAll(java.util.Collection) -> addAll
    void clear() -> clear
    boolean contains(java.lang.Object) -> contains
    boolean containsAll(java.util.Collection) -> containsAll
    boolean isEmpty() -> isEmpty
    java.util.Iterator iterator() -> iterator
    boolean remove(java.lang.Object) -> remove
    boolean removeAll(java.util.Collection) -> removeAll
    boolean retainAll(java.util.Collection) -> retainAll
    int size() -> size
    java.lang.Object[] toArray() -> toArray
    java.lang.Object[] toArray(java.lang.Object[]) -> toArray
org.sidiff.core.compare.similarities.impl.AdaptedIterator -> org.sidiff.core.compare.similarities.impl.o:
    org.sidiff.core.compare.similarities.impl.ContentAdapter contentAdapter -> a
    java.util.Iterator adaptableIterator -> b
    boolean hasNext() -> hasNext
    java.lang.Object next() -> next
    void remove() -> remove
org.sidiff.core.compare.similarities.impl.AdaptedSet -> org.sidiff.core.compare.similarities.impl.i:
org.sidiff.core.compare.similarities.impl.AdaptedSortedSet -> org.sidiff.core.compare.similarities.impl.h:
    java.util.SortedSet adaptableSortedSet -> d
    java.util.Comparator comparator() -> comparator
    java.lang.Object first() -> first
    java.lang.Object last() -> last
    java.util.SortedSet headSet(java.lang.Object) -> headSet
    java.util.SortedSet subSet(java.lang.Object,java.lang.Object) -> subSet
    java.util.SortedSet tailSet(java.lang.Object) -> tailSet
org.sidiff.core.compare.similarities.impl.ContentAdapter -> org.sidiff.core.compare.similarities.impl.ContentAdapter:
    java.lang.Object adapt(java.lang.Object) -> b
    java.lang.Object unadapt(java.lang.Object) -> a
org.sidiff.core.compare.similarities.impl.NotAdaptedException -> org.sidiff.core.compare.similarities.impl.k:
    long serialVersionUID -> a
org.sidiff.core.compare.similarities.impl.SimilaritiesServiceImpl -> org.sidiff.core.compare.similarities.impl.j:
    java.util.Comparator eObjectComparator -> b
    java.util.SortedSet EMPTY_SORTED_SET -> c
    org.eclipse.emf.ecore.resource.Resource resourceA -> d
    org.eclipse.emf.ecore.resource.Resource resourceB -> e
    java.util.Map simFromA -> f
    java.util.Map simFromB -> g
    java.util.Map indexAB -> h
    boolean $assertionsDisabled -> a
    org.eclipse.emf.ecore.EObject getFromResource(org.eclipse.emf.ecore.resource.Resource,org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject) -> a
    void initialize(org.sidiff.common.services.ServiceContext,java.lang.Object[]) -> a
    void initialize(java.lang.Object[]) -> a
    java.util.SortedSet getSimilarities(org.eclipse.emf.ecore.EObject) -> b
    float getSimilarityDegree(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject) -> a
    void setSimilarity(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject,float) -> a
    void dispose(org.eclipse.emf.ecore.EObject) -> a
    org.sidiff.core.compare.similarities.impl.SymmetricSimilarity gocFromIndex(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject,boolean) -> a
org.sidiff.core.compare.similarities.impl.SimilaritiesServiceImpl$1 -> org.sidiff.core.compare.similarities.impl.c:
    int compare(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject) -> a
    int compare(java.lang.Object,java.lang.Object) -> compare
org.sidiff.core.compare.similarities.impl.SimilaritiesServiceProviderImpl -> org.sidiff.core.compare.similarities.impl.n:
    java.lang.Object createInstance() -> a
org.sidiff.core.compare.similarities.impl.SimilarityAdapter -> org.sidiff.core.compare.similarities.impl.a:
    int ASIM -> a
    int BSIM -> b
    int adapterMode -> c
    org.sidiff.core.compare.similarities.Similarity adapt(org.sidiff.core.compare.similarities.impl.SymmetricSimilarity) -> a
    org.sidiff.core.compare.similarities.impl.SymmetricSimilarity unadapt(org.sidiff.core.compare.similarities.Similarity) -> a
    java.lang.Object unadapt(java.lang.Object) -> a
    java.lang.Object adapt(java.lang.Object) -> b
    int access$2(org.sidiff.core.compare.similarities.impl.SimilarityAdapter) -> a
org.sidiff.core.compare.similarities.impl.SimilarityAdapter$SimilarityWrapper -> org.sidiff.core.compare.similarities.impl.d:
    org.sidiff.core.compare.similarities.impl.SymmetricSimilarity adaptable -> b
    org.sidiff.core.compare.similarities.impl.SimilarityAdapter this$0 -> a
    org.eclipse.emf.ecore.EObject getSimilarObject() -> a
    float getSimilarity() -> b
    boolean equals(java.lang.Object) -> equals
    java.lang.String toString() -> toString
org.sidiff.core.compare.similarities.impl.SymmetricSimilarity -> org.sidiff.core.compare.similarities.impl.g:
    org.eclipse.emf.ecore.EObject elementA -> a
    org.eclipse.emf.ecore.EObject elementB -> b
    float similarity -> c
    org.eclipse.emf.ecore.EObject getElementA() -> a
    org.eclipse.emf.ecore.EObject getElementB() -> b
    float getSimilarity() -> c
    void setSimilarity(float) -> a
    int compareTo(org.sidiff.core.compare.similarities.impl.SymmetricSimilarity) -> a
    int compareTo(java.lang.Object) -> compareTo
org.sidiff.core.compare.similarities.impl.SyncronizedContainer -> org.sidiff.core.compare.similarities.impl.SyncronizedContainer:
    void changeAnnounce(org.sidiff.core.compare.similarities.impl.SyncronizedContent) -> a
    void changePerformed(org.sidiff.core.compare.similarities.impl.SyncronizedContent) -> b
org.sidiff.core.compare.similarities.impl.SyncronizedContent -> org.sidiff.core.compare.similarities.impl.SyncronizedContent:
    void addSyncronizedContainer(org.sidiff.core.compare.similarities.impl.SyncronizedContainer) -> a
    boolean removeSyncronizedContainer(org.sidiff.core.compare.similarities.impl.SyncronizedContainer) -> b
org.sidiff.core.compare.similarities.impl.SyncronizedContentSupport -> org.sidiff.core.compare.similarities.impl.b:
    java.util.List syncronizedContainers -> a
    void addSyncronizedContainer(org.sidiff.core.compare.similarities.impl.SyncronizedContainer) -> a
    boolean removeSyncronizedContainer(org.sidiff.core.compare.similarities.impl.SyncronizedContainer) -> b
    void fireChangeAnnounce(org.sidiff.core.compare.similarities.impl.SyncronizedContent) -> a
    void fireChangePerformed(org.sidiff.core.compare.similarities.impl.SyncronizedContent) -> b
org.sidiff.core.compare.similarities.impl.SyncronizedSortedSet -> org.sidiff.core.compare.similarities.impl.l:
    long serialVersionUID -> a
    boolean add(org.sidiff.core.compare.similarities.impl.SyncronizedContent) -> c
    boolean remove(java.lang.Object) -> remove
    void changeAnnounce(org.sidiff.core.compare.similarities.impl.SyncronizedContent) -> a
    void changePerformed(org.sidiff.core.compare.similarities.impl.SyncronizedContent) -> b
    boolean add(java.lang.Object) -> add
org.sidiff.core.compare.similarities.impl.UnadaptedOperationException -> org.sidiff.core.compare.similarities.impl.m:
    long serialVersionUID -> a
org.sidiff.core.constraints.Activator -> org.sidiff.core.constraints.c:
    void start(org.osgi.framework.BundleContext) -> start
    void stop(org.osgi.framework.BundleContext) -> stop
org.sidiff.core.constraints.Constraint -> org.sidiff.core.constraints.a:
    org.eclipse.emf.ecore.EClass eClass -> a
    org.sidiff.common.services.ServiceContext context -> b
    void setContext(org.sidiff.common.services.ServiceContext) -> a
    void init() -> a
    boolean checkConstraint(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject) -> a
    org.eclipse.emf.ecore.EClass getEClass() -> b
    org.sidiff.common.services.ServiceContext getContext() -> c
    java.lang.String[] splitParam(java.lang.String) -> a
org.sidiff.core.constraints.FixedAnnotationValue -> org.sidiff.core.constraints.g:
    java.lang.String NAME_VALUE_SEPERATOR -> d
    java.lang.String key -> a
    java.lang.String value -> b
    boolean $assertionsDisabled -> c
    boolean checkConstraint(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject) -> a
org.sidiff.core.constraints.FixedAttributeValue -> org.sidiff.core.constraints.d:
    org.eclipse.emf.ecore.EAttribute attribute -> a
    java.lang.String value -> b
    boolean $assertionsDisabled -> c
    boolean checkConstraint(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject) -> a
    void init() -> a
org.sidiff.core.constraints.HasAnnotation -> org.sidiff.core.constraints.h:
    java.lang.String key -> a
    boolean $assertionsDisabled -> b
    boolean checkConstraint(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject) -> a
    void init() -> a
org.sidiff.core.constraints.ParentsMatched -> org.sidiff.core.constraints.i:
    boolean hasToBeMatched -> b
    org.sidiff.core.correspondences.CorrespondencesService correspondeces -> c
    boolean $assertionsDisabled -> a
    void init() -> a
    boolean checkConstraint(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject) -> a
org.sidiff.core.constraints.RemoteNodesMatched -> org.sidiff.core.constraints.e:
    org.sidiff.common.emf.access.EMFPath emfPath -> b
    boolean hasToBeMatched -> c
    org.sidiff.core.correspondences.CorrespondencesService correspondeces -> d
    boolean $assertionsDisabled -> a
    boolean checkConstraint(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject) -> a
    void init() -> a
org.sidiff.core.constraints.SameAnnotationValue -> org.sidiff.core.constraints.f:
    java.lang.String keyA -> a
    java.lang.String keyB -> b
    boolean $assertionsDisabled -> c
    boolean checkConstraint(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject) -> a
    void init() -> a
org.sidiff.core.constraints.SameAttribueValue -> org.sidiff.core.constraints.b:
    org.eclipse.emf.ecore.EAttribute attributeA -> a
    org.eclipse.emf.ecore.EAttribute attributeB -> b
    boolean $assertionsDisabled -> c
    boolean checkConstraint(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject) -> a
    void init() -> a
org.sidiff.core.correspondences.CannotMatchException -> org.sidiff.core.correspondences.b:
org.sidiff.core.correspondences.CorrespondencesDebugger -> org.sidiff.core.correspondences.a:
    java.lang.String countmatches(org.sidiff.core.correspondences.CorrespondencesService,org.eclipse.emf.ecore.resource.Resource) -> a
    java.lang.String unmatched(org.sidiff.core.correspondences.CorrespondencesService,org.eclipse.emf.ecore.resource.Resource) -> b
    java.lang.String matched(org.sidiff.core.correspondences.CorrespondencesService,org.eclipse.emf.ecore.resource.Resource) -> c
org.sidiff.core.correspondences.CorrespondencesService -> org.sidiff.core.correspondences.CorrespondencesService:
    void addCorrespondence(org.eclipse.emf.ecore.EObject[]) -> a
    void addCorrespondence(java.util.Collection) -> a
    boolean hasCorrespondences(org.eclipse.emf.ecore.EObject) -> a
    boolean isCorresponding(org.eclipse.emf.ecore.EObject[]) -> b
    boolean isCorresponding(java.util.Collection) -> b
    java.util.Collection getCorrespondences(org.eclipse.emf.ecore.EObject) -> b
    java.util.Collection getElementsWithCorrespondences(org.eclipse.emf.ecore.resource.Resource) -> a
    java.util.Collection getElementsWithoutCorrespondences(org.eclipse.emf.ecore.resource.Resource) -> b
    void removeCorrespondence(org.eclipse.emf.ecore.EObject[]) -> c
    void removeCorrespondence(java.util.Collection) -> c
    void removeCorrespondences(org.eclipse.emf.ecore.EObject) -> c
    void removeCorrespondences(java.util.Collection) -> d
org.sidiff.core.correspondences.CorrespondencesServiceProvider -> org.sidiff.core.correspondences.CorrespondencesServiceProvider:
org.sidiff.core.correspondences.NoMatchException -> org.sidiff.core.correspondences.d:
org.sidiff.core.correspondences.OverlappingMatchException -> org.sidiff.core.correspondences.c:
org.sidiff.core.correspondences.pairtable.Activator -> org.sidiff.core.correspondences.pairtable.a:
    void start(org.osgi.framework.BundleContext) -> start
    void stop(org.osgi.framework.BundleContext) -> stop
org.sidiff.core.correspondences.pairtable.PairTableService -> org.sidiff.core.correspondences.pairtable.PairTableService:
org.sidiff.core.correspondences.pairtable.PairTableServiceProvider -> org.sidiff.core.correspondences.pairtable.PairTableServiceProvider:
org.sidiff.core.correspondences.pairtable.impl.PairTableServiceImpl -> org.sidiff.core.correspondences.pairtable.impl.b:
    org.eclipse.emf.ecore.resource.Resource modelA -> b
    org.eclipse.emf.ecore.resource.Resource modelB -> c
    java.util.Map unmatchedInA -> d
    java.util.Set allUnmatchedInA -> e
    java.util.Map unmatchedInB -> f
    java.util.Set allUnmatchedInB -> g
    java.util.Map matchedAB -> h
    java.util.Map matchedBA -> i
    boolean $assertionsDisabled -> a
    void initialize(org.sidiff.common.services.ServiceContext,java.lang.Object[]) -> a
    void addCorrespondence(org.eclipse.emf.ecore.EObject[]) -> a
    void addCorrespondence(java.util.Collection) -> a
    java.util.Collection getCorrespondences(org.eclipse.emf.ecore.EObject) -> b
    boolean hasCorrespondences(org.eclipse.emf.ecore.EObject) -> a
    boolean isCorresponding(org.eclipse.emf.ecore.EObject[]) -> b
    boolean isCorresponding(java.util.Collection) -> b
    java.util.Collection getElementsWithCorrespondences(org.eclipse.emf.ecore.resource.Resource) -> a
    java.util.Collection getElementsWithoutCorrespondences(org.eclipse.emf.ecore.resource.Resource) -> b
    void removeCorrespondence(org.eclipse.emf.ecore.EObject[]) -> c
    void removeCorrespondence(java.util.Collection) -> c
    void removeCorrespondences(org.eclipse.emf.ecore.EObject) -> c
    void removeCorrespondences(java.util.Collection) -> d
    org.eclipse.emf.ecore.EObject[] getAsPair(java.util.Collection) -> e
org.sidiff.core.correspondences.pairtable.impl.PairTableServiceProviderImpl -> org.sidiff.core.correspondences.pairtable.impl.a:
    java.lang.Object createInstance() -> a
org.sidiff.core.correspondences.util.CorrespondencesUtil -> org.sidiff.core.correspondences.util.a:
    java.util.Collection removeMatchedElements(org.sidiff.core.correspondences.CorrespondencesService,java.util.Collection,java.util.Collection) -> a
org.sidiff.core.difference.DifferenceClassifiers -> org.sidiff.core.difference.b:
org.sidiff.core.difference.DifferenceSelectors -> org.sidiff.core.difference.a:
org.sidiff.core.difference.DifferenceService -> org.sidiff.core.difference.DifferenceService:
    void compute() -> b
    java.util.Collection getUnchangedElements(org.eclipse.emf.ecore.resource.Resource) -> b
    java.util.Collection getChangedElements(org.eclipse.emf.ecore.resource.Resource) -> a
    java.util.Map getChangedAttributes(org.eclipse.emf.ecore.EObject) -> a
    java.util.Map getChangedReferences(org.eclipse.emf.ecore.EObject) -> b
org.sidiff.core.difference.DifferenceServiceProvider -> org.sidiff.core.difference.DifferenceServiceProvider:
org.sidiff.core.difference.differencemodel.DifferenceModelService -> org.sidiff.core.difference.differencemodel.DifferenceModelService:
    org.sidiff.core.difference.model.DeltaModel getModel() -> a
org.sidiff.core.difference.differencemodel.DifferenceModelServiceProvider -> org.sidiff.core.difference.differencemodel.DifferenceModelServiceProvider:
org.sidiff.core.difference.differencemodel.internal.Activator -> org.sidiff.core.difference.differencemodel.internal.c:
    java.util.Map URIMAP -> b
    org.sidiff.common.emf.modelstorage.Loader diffModelLoader -> a
    void start(org.osgi.framework.BundleContext) -> start
    void stop(org.osgi.framework.BundleContext) -> stop
    java.util.Map access$0() -> a
org.sidiff.core.difference.differencemodel.internal.Activator$1 -> org.sidiff.core.difference.differencemodel.internal.b:
    org.sidiff.core.difference.differencemodel.internal.Activator this$0 -> a
    java.util.Set getMagicKeys() -> getMagicKeys
    java.lang.String getSuffix() -> getSuffix
    java.util.Map getSchemaLocationMappings() -> getSchemaLocationMappings
    java.lang.String getLoaderDescription() -> getLoaderDescription
org.sidiff.core.difference.differencemodel.internal.DifferenceModelBuilder -> org.sidiff.core.difference.differencemodel.internal.e:
    java.lang.String ABSOLUTE_POSITION_ANNOTATION -> c
    java.lang.String RELATIVE_POSITION_ANNOTATION -> d
    java.lang.String IGNORE_DIFF_ANNOTATION -> e
    org.sidiff.core.difference.differencemodel.internal.EquityChecker equalsEquity -> a
    org.sidiff.core.correspondences.CorrespondencesService correspondences -> f
    org.sidiff.core.difference.differencemodel.internal.EquityChecker matchedEquity -> g
    java.util.Map containmentChangeByContainedObject -> h
    java.util.Collection unlinkedMoves -> i
    boolean $assertionsDisabled -> b
    org.sidiff.core.difference.model.DeltaModel computeDifference(org.sidiff.core.correspondences.CorrespondencesService,org.eclipse.emf.ecore.resource.Resource,org.eclipse.emf.ecore.resource.Resource) -> a
    boolean joinChangesToModel(org.sidiff.core.difference.model.DeltaModel,org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject) -> a
    void joinMovesToModel(org.sidiff.core.difference.model.DeltaModel) -> a
    boolean joinStructuralChangesToModel(org.sidiff.core.difference.model.DeltaModel,org.eclipse.emf.ecore.EStructuralFeature,org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject) -> a
    boolean indexCenteredDifference(org.sidiff.core.difference.model.DeltaModel,org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EStructuralFeature,java.util.List,java.util.List,org.sidiff.core.difference.differencemodel.internal.EquityChecker) -> a
    boolean sequencedCenteredDifference(org.sidiff.core.difference.model.DeltaModel,org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EStructuralFeature,java.util.List,java.util.List,org.sidiff.core.difference.differencemodel.internal.EquityChecker) -> b
    org.sidiff.core.difference.model.Change createChange(org.eclipse.emf.ecore.EStructuralFeature,org.eclipse.emf.ecore.EObject,java.lang.Object,org.eclipse.emf.ecore.EObject,java.lang.Object,boolean,int[]) -> a
    org.sidiff.core.difference.model.UnmatchedElement createUnmatchedElement(org.eclipse.emf.ecore.EObject) -> a
    org.sidiff.core.difference.model.UnchangedElement createUnchangedElement(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject) -> a
    int findLocalMove(java.lang.Object,java.util.List,org.sidiff.core.difference.differencemodel.internal.EquityChecker,java.util.SortedSet) -> a
    boolean _checkContainments(java.util.Collection) -> a
org.sidiff.core.difference.differencemodel.internal.DifferenceModelBuilder$VirtualIndex -> org.sidiff.core.difference.differencemodel.internal.g:
    int absoluteIndex -> b
    int virtualIndex -> c
    org.sidiff.core.difference.differencemodel.internal.DifferenceModelBuilder$VirtualIndex succsessor -> d
    org.sidiff.core.difference.differencemodel.internal.DifferenceModelBuilder this$0 -> a
    void increaseFollowing() -> a
    void decreaseFollowing() -> b
    int getAbsoluteIndex() -> c
    int getVirtualIndex() -> d
    org.sidiff.core.difference.differencemodel.internal.DifferenceModelBuilder$VirtualIndex getSuccsessor() -> e
    int compareTo(org.sidiff.core.difference.differencemodel.internal.DifferenceModelBuilder$VirtualIndex) -> a
    java.lang.String toString() -> toString
    int compareTo(java.lang.Object) -> compareTo
    int access$2(org.sidiff.core.difference.differencemodel.internal.DifferenceModelBuilder$VirtualIndex) -> b
    int access$3(org.sidiff.core.difference.differencemodel.internal.DifferenceModelBuilder$VirtualIndex) -> c
    void access$4(org.sidiff.core.difference.differencemodel.internal.DifferenceModelBuilder$VirtualIndex) -> d
    org.sidiff.core.difference.differencemodel.internal.DifferenceModelBuilder$VirtualIndex access$5(org.sidiff.core.difference.differencemodel.internal.DifferenceModelBuilder$VirtualIndex) -> e
    int access$6(org.sidiff.core.difference.differencemodel.internal.DifferenceModelBuilder$VirtualIndex) -> f
    void access$7(org.sidiff.core.difference.differencemodel.internal.DifferenceModelBuilder$VirtualIndex) -> g
org.sidiff.core.difference.differencemodel.internal.DifferenceModelServiceImpl -> org.sidiff.core.difference.differencemodel.internal.h:
    org.sidiff.core.difference.differencemodel.internal.DifferenceModelBuilder modelBuilder -> b
    org.sidiff.common.services.ServiceContext context -> c
    org.eclipse.emf.ecore.resource.Resource resourceA -> d
    org.eclipse.emf.ecore.resource.Resource resourceB -> e
    org.sidiff.core.difference.model.DeltaModel differenceModel -> f
    java.util.Map attributeChangeCache -> g
    java.util.Map referenceChangeCache -> h
    java.util.Collection unchangedACache -> i
    java.util.Collection unchangedBCache -> j
    java.util.Collection changedACache -> k
    java.util.Collection changedBCache -> l
    boolean $assertionsDisabled -> a
    org.sidiff.core.difference.model.DeltaModel getModel() -> a
    void compute() -> b
    java.util.Collection getChangedElements(org.eclipse.emf.ecore.resource.Resource) -> a
    java.util.Collection getUnchangedElements(org.eclipse.emf.ecore.resource.Resource) -> b
    java.util.Map getChangedAttributes(org.eclipse.emf.ecore.EObject) -> a
    java.util.Map getChangedReferences(org.eclipse.emf.ecore.EObject) -> b
    void initialize(org.sidiff.common.services.ServiceContext,java.lang.Object[]) -> a
    void computeChangedDifferenceCaches() -> c
    void computeUnchangedDifferenceCaches() -> d
    void computeAttributeDifferenceCaches() -> e
    void computeReferenceDifferenceCaches() -> f
    java.util.Map gocFeatureChangeMap(org.eclipse.emf.ecore.EObject,java.util.Map) -> a
    java.util.Collection gocContents(java.lang.Object,java.util.Map) -> a
org.sidiff.core.difference.differencemodel.internal.DifferenceModelServiceProviderImpl -> org.sidiff.core.difference.differencemodel.internal.d:
    java.lang.Object createInstance() -> a
org.sidiff.core.difference.differencemodel.internal.DifferenceStringResolver -> org.sidiff.core.difference.differencemodel.internal.j:
    java.lang.Class dedicatedClass() -> a
    java.lang.String resolve(java.lang.Object) -> a
org.sidiff.core.difference.differencemodel.internal.EqualsEquityChecker -> org.sidiff.core.difference.differencemodel.internal.a:
    boolean $assertionsDisabled -> a
    boolean checkEquity(java.lang.Object,java.lang.Object) -> a
org.sidiff.core.difference.differencemodel.internal.EquityChecker -> org.sidiff.core.difference.differencemodel.internal.i:
    boolean equals(java.lang.Object,java.lang.Object) -> b
    boolean checkEquity(java.lang.Object,java.lang.Object) -> a
org.sidiff.core.difference.differencemodel.internal.MatchEquityChecker -> org.sidiff.core.difference.differencemodel.internal.f:
    org.sidiff.core.correspondences.CorrespondencesService correspondences -> b
    org.eclipse.emf.ecore.resource.Resource[] resources -> c
    boolean $assertionsDisabled -> a
    boolean checkEquity(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject) -> a
    boolean checkEquity(java.lang.Object,java.lang.Object) -> a
org.sidiff.core.difference.model.AttributeChange -> org.sidiff.core.difference.model.AttributeChange:
    org.eclipse.emf.ecore.EAttribute getEAttribute() -> c_
    void setEAttribute(org.eclipse.emf.ecore.EAttribute) -> a
    java.lang.Object getValueA() -> d_
    void setValueA(java.lang.Object) -> a
    java.lang.Object getValueB() -> f
    void setValueB(java.lang.Object) -> b
org.sidiff.core.difference.model.AttributeIValueChange -> org.sidiff.core.difference.model.AttributeIValueChange:
org.sidiff.core.difference.model.AttributeIValueNotInA -> org.sidiff.core.difference.model.AttributeIValueNotInA:
org.sidiff.core.difference.model.AttributeIValueNotInB -> org.sidiff.core.difference.model.AttributeIValueNotInB:
org.sidiff.core.difference.model.AttributeValueChange -> org.sidiff.core.difference.model.AttributeValueChange:
org.sidiff.core.difference.model.AttributeValueMove -> org.sidiff.core.difference.model.AttributeValueMove:
org.sidiff.core.difference.model.AttributeValueNotInA -> org.sidiff.core.difference.model.AttributeValueNotInA:
org.sidiff.core.difference.model.AttributeValueNotInB -> org.sidiff.core.difference.model.AttributeValueNotInB:
org.sidiff.core.difference.model.Change -> org.sidiff.core.difference.model.Change:
    org.eclipse.emf.ecore.EObject getChangedB() -> a
    void setChangedB(org.eclipse.emf.ecore.EObject) -> a
    org.eclipse.emf.ecore.EObject getChangedA() -> c
    void setChangedA(org.eclipse.emf.ecore.EObject) -> b
org.sidiff.core.difference.model.ComplexOperation -> org.sidiff.core.difference.model.ComplexOperation:
    java.lang.String getName() -> a
    void setName(java.lang.String) -> a
    org.eclipse.emf.common.util.EList getChanges() -> b
org.sidiff.core.difference.model.DeltaModel -> org.sidiff.core.difference.model.DeltaModel:
    org.eclipse.emf.common.util.EList getChanges() -> a
    org.eclipse.emf.common.util.EList getUnmatchedA() -> b
    org.eclipse.emf.common.util.EList getUnmatchedB() -> c
    org.eclipse.emf.common.util.EList getTask() -> d
    org.eclipse.emf.common.util.EList getUnchangedElement() -> e
org.sidiff.core.difference.model.Difference -> org.sidiff.core.difference.model.Difference:
org.sidiff.core.difference.model.DifferenceFactory -> org.sidiff.core.difference.model.DifferenceFactory:
    org.sidiff.core.difference.model.DifferenceFactory eINSTANCE -> a
    org.sidiff.core.difference.model.AttributeIValueChange createAttributeIValueChange() -> b
    org.sidiff.core.difference.model.AttributeValueChange createAttributeValueChange() -> c
    org.sidiff.core.difference.model.AttributeIValueNotInA createAttributeIValueNotInA() -> d
    org.sidiff.core.difference.model.AttributeValueNotInA createAttributeValueNotInA() -> e
    org.sidiff.core.difference.model.AttributeIValueNotInB createAttributeIValueNotInB() -> f
    org.sidiff.core.difference.model.AttributeValueNotInB createAttributeValueNotInB() -> g
    org.sidiff.core.difference.model.AttributeValueMove createAttributeValueMove() -> h
    org.sidiff.core.difference.model.ComplexOperation createComplexOperation() -> i
    org.sidiff.core.difference.model.DeltaModel createDeltaModel() -> j
    org.sidiff.core.difference.model.UnmatchedElement createUnmatchedElement() -> k
    org.sidiff.core.difference.model.Task createTask() -> l
    org.sidiff.core.difference.model.UnchangedElement createUnchangedElement() -> m
    org.sidiff.core.difference.model.LocalMove createLocalMove() -> n
    org.sidiff.core.difference.model.Move createMove() -> o
    org.sidiff.core.difference.model.ReferenceINotInA createReferenceINotInA() -> p
    org.sidiff.core.difference.model.ReferenceNotInA createReferenceNotInA() -> q
    org.sidiff.core.difference.model.ReferenceINotInB createReferenceINotInB() -> r
    org.sidiff.core.difference.model.ReferenceNotInB createReferenceNotInB() -> s
    org.sidiff.core.difference.model.ReferenceITargetChange createReferenceITargetChange() -> t
    org.sidiff.core.difference.model.ReferenceTargetChange createReferenceTargetChange() -> u
    org.sidiff.core.difference.model.DifferencePackage getDifferencePackage() -> v
org.sidiff.core.difference.model.DifferencePackage -> org.sidiff.core.difference.model.DifferencePackage:
    java.lang.String eNAME -> a
    java.lang.String eNS_URI -> b
    java.lang.String eNS_PREFIX -> c
    org.sidiff.core.difference.model.DifferencePackage eINSTANCE -> d
    int DIFFERENCE -> e
    int DIFFERENCE_FEATURE_COUNT -> f
    int CHANGE -> g
    int CHANGE__CHANGED_B -> h
    int CHANGE__CHANGED_A -> i
    int CHANGE_FEATURE_COUNT -> j
    int ATTRIBUTE_CHANGE -> k
    int ATTRIBUTE_CHANGE__CHANGED_B -> l
    int ATTRIBUTE_CHANGE__CHANGED_A -> m
    int ATTRIBUTE_CHANGE__EATTRIBUTE -> n
    int ATTRIBUTE_CHANGE__VALUE_A -> o
    int ATTRIBUTE_CHANGE__VALUE_B -> p
    int ATTRIBUTE_CHANGE_FEATURE_COUNT -> q
    int ATTRIBUTE_VALUE_CHANGE -> r
    int ATTRIBUTE_VALUE_CHANGE__CHANGED_B -> s
    int ATTRIBUTE_VALUE_CHANGE__CHANGED_A -> t
    int ATTRIBUTE_VALUE_CHANGE__EATTRIBUTE -> u
    int ATTRIBUTE_VALUE_CHANGE__VALUE_A -> v
    int ATTRIBUTE_VALUE_CHANGE__VALUE_B -> w
    int ATTRIBUTE_VALUE_CHANGE_FEATURE_COUNT -> x
    int ATTRIBUTE_IVALUE_CHANGE -> y
    int ATTRIBUTE_IVALUE_CHANGE__CHANGED_B -> z
    int ATTRIBUTE_IVALUE_CHANGE__CHANGED_A -> A
    int ATTRIBUTE_IVALUE_CHANGE__EATTRIBUTE -> B
    int ATTRIBUTE_IVALUE_CHANGE__VALUE_A -> C
    int ATTRIBUTE_IVALUE_CHANGE__VALUE_B -> D
    int ATTRIBUTE_IVALUE_CHANGE__POSITION -> E
    int ATTRIBUTE_IVALUE_CHANGE_FEATURE_COUNT -> F
    int INDEXED_CHANGE -> G
    int INDEXED_CHANGE__POSITION -> H
    int INDEXED_CHANGE_FEATURE_COUNT -> I
    int ATTRIBUTE_VALUE_NOT_IN_A -> J
    int ATTRIBUTE_VALUE_NOT_IN_A__CHANGED_B -> K
    int ATTRIBUTE_VALUE_NOT_IN_A__CHANGED_A -> L
    int ATTRIBUTE_VALUE_NOT_IN_A__EATTRIBUTE -> M
    int ATTRIBUTE_VALUE_NOT_IN_A__VALUE_A -> N
    int ATTRIBUTE_VALUE_NOT_IN_A__VALUE_B -> O
    int ATTRIBUTE_VALUE_NOT_IN_A_FEATURE_COUNT -> P
    int ATTRIBUTE_IVALUE_NOT_IN_A -> Q
    int ATTRIBUTE_IVALUE_NOT_IN_A__CHANGED_B -> R
    int ATTRIBUTE_IVALUE_NOT_IN_A__CHANGED_A -> S
    int ATTRIBUTE_IVALUE_NOT_IN_A__EATTRIBUTE -> T
    int ATTRIBUTE_IVALUE_NOT_IN_A__VALUE_A -> U
    int ATTRIBUTE_IVALUE_NOT_IN_A__VALUE_B -> V
    int ATTRIBUTE_IVALUE_NOT_IN_A__POSITION -> W
    int ATTRIBUTE_IVALUE_NOT_IN_A_FEATURE_COUNT -> X
    int ATTRIBUTE_VALUE_NOT_IN_B -> Y
    int ATTRIBUTE_VALUE_NOT_IN_B__CHANGED_B -> Z
    int ATTRIBUTE_VALUE_NOT_IN_B__CHANGED_A -> aa
    int ATTRIBUTE_VALUE_NOT_IN_B__EATTRIBUTE -> ab
    int ATTRIBUTE_VALUE_NOT_IN_B__VALUE_A -> ac
    int ATTRIBUTE_VALUE_NOT_IN_B__VALUE_B -> ad
    int ATTRIBUTE_VALUE_NOT_IN_B_FEATURE_COUNT -> ae
    int ATTRIBUTE_IVALUE_NOT_IN_B -> af
    int ATTRIBUTE_IVALUE_NOT_IN_B__CHANGED_B -> ag
    int ATTRIBUTE_IVALUE_NOT_IN_B__CHANGED_A -> ah
    int ATTRIBUTE_IVALUE_NOT_IN_B__EATTRIBUTE -> ai
    int ATTRIBUTE_IVALUE_NOT_IN_B__VALUE_A -> aj
    int ATTRIBUTE_IVALUE_NOT_IN_B__VALUE_B -> ak
    int ATTRIBUTE_IVALUE_NOT_IN_B__POSITION -> al
    int ATTRIBUTE_IVALUE_NOT_IN_B_FEATURE_COUNT -> am
    int ATTRIBUTE_VALUE_MOVE -> an
    int ATTRIBUTE_VALUE_MOVE__CHANGED_B -> ao
    int ATTRIBUTE_VALUE_MOVE__CHANGED_A -> ap
    int ATTRIBUTE_VALUE_MOVE__EATTRIBUTE -> aq
    int ATTRIBUTE_VALUE_MOVE__VALUE_A -> ar
    int ATTRIBUTE_VALUE_MOVE__VALUE_B -> as
    int ATTRIBUTE_VALUE_MOVE__POSITION_A -> at
    int ATTRIBUTE_VALUE_MOVE__POSITION_B -> au
    int ATTRIBUTE_VALUE_MOVE_FEATURE_COUNT -> av
    int MOVE_CHANGE -> aw
    int MOVE_CHANGE__POSITION_A -> ax
    int MOVE_CHANGE__POSITION_B -> ay
    int MOVE_CHANGE_FEATURE_COUNT -> az
    int COMPLEX_OPERATION -> aA
    int COMPLEX_OPERATION__NAME -> aB
    int COMPLEX_OPERATION__CHANGES -> aC
    int COMPLEX_OPERATION_FEATURE_COUNT -> aD
    int DELTA_MODEL -> aE
    int DELTA_MODEL__CHANGES -> aF
    int DELTA_MODEL__UNMATCHED_A -> aG
    int DELTA_MODEL__UNMATCHED_B -> aH
    int DELTA_MODEL__TASK -> aI
    int DELTA_MODEL__UNCHANGED_ELEMENT -> aJ
    int DELTA_MODEL_FEATURE_COUNT -> aK
    int UNMATCHED_ELEMENT -> aL
    int UNMATCHED_ELEMENT__AFFECTED_CONTAINMENT -> aM
    int UNMATCHED_ELEMENT__UNMATCHED_ELEMENT -> aN
    int UNMATCHED_ELEMENT_FEATURE_COUNT -> aO
    int REFERENCE_CHANGE -> aP
    int REFERENCE_CHANGE__CHANGED_B -> aQ
    int REFERENCE_CHANGE__CHANGED_A -> aR
    int REFERENCE_CHANGE__EREFERENCE -> aS
    int REFERENCE_CHANGE__TARGET_B -> aT
    int REFERENCE_CHANGE__TARGET_A -> aU
    int REFERENCE_CHANGE_FEATURE_COUNT -> aV
    int TASK -> aW
    int TASK__DIFFERENCE -> aX
    int TASK__TASK -> aY
    int TASK__NAME -> aZ
    int TASK__BESCHREIBUNG -> ba
    int TASK_FEATURE_COUNT -> bb
    int UNCHANGED_ELEMENT -> bc
    int UNCHANGED_ELEMENT__UNCHANGED_A -> bd
    int UNCHANGED_ELEMENT__UNCHANGED_B -> be
    int UNCHANGED_ELEMENT_FEATURE_COUNT -> bf
    int LOCAL_MOVE -> bg
    int LOCAL_MOVE__CHANGED_B -> bh
    int LOCAL_MOVE__CHANGED_A -> bi
    int LOCAL_MOVE__EREFERENCE -> bj
    int LOCAL_MOVE__TARGET_B -> bk
    int LOCAL_MOVE__TARGET_A -> bl
    int LOCAL_MOVE__POSITION_A -> bm
    int LOCAL_MOVE__POSITION_B -> bn
    int LOCAL_MOVE_FEATURE_COUNT -> bo
    int MOVE -> bp
    int MOVE__CHANGED_B -> bq
    int MOVE__CHANGED_A -> br
    int MOVE__REFERENCE_CHANGE_A -> bs
    int MOVE__REFERENCE_CHANGE_B -> bt
    int MOVE_FEATURE_COUNT -> bu
    int REFERENCE_NOT_IN_A -> bv
    int REFERENCE_NOT_IN_A__CHANGED_B -> bw
    int REFERENCE_NOT_IN_A__CHANGED_A -> bx
    int REFERENCE_NOT_IN_A__EREFERENCE -> by
    int REFERENCE_NOT_IN_A__TARGET_B -> bz
    int REFERENCE_NOT_IN_A__TARGET_A -> bA
    int REFERENCE_NOT_IN_A_FEATURE_COUNT -> bB
    int REFERENCE_INOT_IN_A -> bC
    int REFERENCE_INOT_IN_A__CHANGED_B -> bD
    int REFERENCE_INOT_IN_A__CHANGED_A -> bE
    int REFERENCE_INOT_IN_A__EREFERENCE -> bF
    int REFERENCE_INOT_IN_A__TARGET_B -> bG
    int REFERENCE_INOT_IN_A__TARGET_A -> bH
    int REFERENCE_INOT_IN_A__POSITION -> bI
    int REFERENCE_INOT_IN_A_FEATURE_COUNT -> bJ
    int REFERENCE_NOT_IN_B -> bK
    int REFERENCE_NOT_IN_B__CHANGED_B -> bL
    int REFERENCE_NOT_IN_B__CHANGED_A -> bM
    int REFERENCE_NOT_IN_B__EREFERENCE -> bN
    int REFERENCE_NOT_IN_B__TARGET_B -> bO
    int REFERENCE_NOT_IN_B__TARGET_A -> bP
    int REFERENCE_NOT_IN_B_FEATURE_COUNT -> bQ
    int REFERENCE_INOT_IN_B -> bR
    int REFERENCE_INOT_IN_B__CHANGED_B -> bS
    int REFERENCE_INOT_IN_B__CHANGED_A -> bT
    int REFERENCE_INOT_IN_B__EREFERENCE -> bU
    int REFERENCE_INOT_IN_B__TARGET_B -> bV
    int REFERENCE_INOT_IN_B__TARGET_A -> bW
    int REFERENCE_INOT_IN_B__POSITION -> bX
    int REFERENCE_INOT_IN_B_FEATURE_COUNT -> bY
    int REFERENCE_TARGET_CHANGE -> bZ
    int REFERENCE_TARGET_CHANGE__CHANGED_B -> ca
    int REFERENCE_TARGET_CHANGE__CHANGED_A -> cb
    int REFERENCE_TARGET_CHANGE__EREFERENCE -> cc
    int REFERENCE_TARGET_CHANGE__TARGET_B -> cd
    int REFERENCE_TARGET_CHANGE__TARGET_A -> ce
    int REFERENCE_TARGET_CHANGE_FEATURE_COUNT -> cf
    int REFERENCE_ITARGET_CHANGE -> cg
    int REFERENCE_ITARGET_CHANGE__CHANGED_B -> ch
    int REFERENCE_ITARGET_CHANGE__CHANGED_A -> ci
    int REFERENCE_ITARGET_CHANGE__EREFERENCE -> cj
    int REFERENCE_ITARGET_CHANGE__TARGET_B -> ck
    int REFERENCE_ITARGET_CHANGE__TARGET_A -> cl
    int REFERENCE_ITARGET_CHANGE__POSITION -> cm
    int REFERENCE_ITARGET_CHANGE_FEATURE_COUNT -> cn
    org.eclipse.emf.ecore.EClass getAttributeChange() -> a
    org.eclipse.emf.ecore.EReference getAttributeChange_EAttribute() -> b
    org.eclipse.emf.ecore.EAttribute getAttributeChange_ValueA() -> c
    org.eclipse.emf.ecore.EAttribute getAttributeChange_ValueB() -> d
    org.eclipse.emf.ecore.EClass getChange() -> e
    org.eclipse.emf.ecore.EReference getChange_ChangedB() -> f
    org.eclipse.emf.ecore.EReference getChange_ChangedA() -> g
    org.eclipse.emf.ecore.EClass getDifference() -> h
    org.eclipse.emf.ecore.EClass getAttributeIValueChange() -> i
    org.eclipse.emf.ecore.EClass getAttributeValueChange() -> j
    org.eclipse.emf.ecore.EClass getIndexedChange() -> k
    org.eclipse.emf.ecore.EAttribute getIndexedChange_Position() -> l
    org.eclipse.emf.ecore.EClass getAttributeIValueNotInA() -> m
    org.eclipse.emf.ecore.EClass getAttributeValueNotInA() -> n
    org.eclipse.emf.ecore.EClass getAttributeIValueNotInB() -> o
    org.eclipse.emf.ecore.EClass getAttributeValueNotInB() -> p
    org.eclipse.emf.ecore.EClass getAttributeValueMove() -> q
    org.eclipse.emf.ecore.EClass getMoveChange() -> r
    org.eclipse.emf.ecore.EAttribute getMoveChange_PositionA() -> s
    org.eclipse.emf.ecore.EAttribute getMoveChange_PositionB() -> t
    org.eclipse.emf.ecore.EClass getComplexOperation() -> u
    org.eclipse.emf.ecore.EAttribute getComplexOperation_Name() -> v
    org.eclipse.emf.ecore.EReference getComplexOperation_Changes() -> w
    org.eclipse.emf.ecore.EClass getDeltaModel() -> x
    org.eclipse.emf.ecore.EReference getDeltaModel_Changes() -> y
    org.eclipse.emf.ecore.EReference getDeltaModel_UnmatchedA() -> z
    org.eclipse.emf.ecore.EReference getDeltaModel_UnmatchedB() -> A
    org.eclipse.emf.ecore.EReference getDeltaModel_Task() -> B
    org.eclipse.emf.ecore.EReference getDeltaModel_UnchangedElement() -> C
    org.eclipse.emf.ecore.EClass getUnmatchedElement() -> D
    org.eclipse.emf.ecore.EReference getUnmatchedElement_AffectedContainment() -> E
    org.eclipse.emf.ecore.EReference getUnmatchedElement_UnmatchedElement() -> F
    org.eclipse.emf.ecore.EClass getReferenceChange() -> G
    org.eclipse.emf.ecore.EReference getReferenceChange_EReference() -> H
    org.eclipse.emf.ecore.EReference getReferenceChange_TargetB() -> I
    org.eclipse.emf.ecore.EReference getReferenceChange_TargetA() -> J
    org.eclipse.emf.ecore.EClass getTask() -> K
    org.eclipse.emf.ecore.EReference getTask_Difference() -> L
    org.eclipse.emf.ecore.EReference getTask_Task() -> M
    org.eclipse.emf.ecore.EAttribute getTask_Name() -> N
    org.eclipse.emf.ecore.EAttribute getTask_Beschreibung() -> O
    org.eclipse.emf.ecore.EClass getUnchangedElement() -> P
    org.eclipse.emf.ecore.EReference getUnchangedElement_UnchangedA() -> Q
    org.eclipse.emf.ecore.EReference getUnchangedElement_UnchangedB() -> R
    org.eclipse.emf.ecore.EClass getLocalMove() -> S
    org.eclipse.emf.ecore.EClass getMove() -> T
    org.eclipse.emf.ecore.EReference getMove_ReferenceChangeA() -> U
    org.eclipse.emf.ecore.EReference getMove_ReferenceChangeB() -> V
    org.eclipse.emf.ecore.EClass getReferenceINotInA() -> W
    org.eclipse.emf.ecore.EClass getReferenceNotInA() -> X
    org.eclipse.emf.ecore.EClass getReferenceINotInB() -> Y
    org.eclipse.emf.ecore.EClass getReferenceNotInB() -> Z
    org.eclipse.emf.ecore.EClass getReferenceITargetChange() -> aa
    org.eclipse.emf.ecore.EClass getReferenceTargetChange() -> ab
    org.sidiff.core.difference.model.DifferenceFactory getDifferenceFactory() -> ac
org.sidiff.core.difference.model.DifferencePackage$Literals -> org.sidiff.core.difference.model.DifferencePackage$Literals:
    org.eclipse.emf.ecore.EClass ATTRIBUTE_CHANGE -> a
    org.eclipse.emf.ecore.EReference ATTRIBUTE_CHANGE__EATTRIBUTE -> b
    org.eclipse.emf.ecore.EAttribute ATTRIBUTE_CHANGE__VALUE_A -> c
    org.eclipse.emf.ecore.EAttribute ATTRIBUTE_CHANGE__VALUE_B -> d
    org.eclipse.emf.ecore.EClass CHANGE -> e
    org.eclipse.emf.ecore.EReference CHANGE__CHANGED_B -> f
    org.eclipse.emf.ecore.EReference CHANGE__CHANGED_A -> g
    org.eclipse.emf.ecore.EClass DIFFERENCE -> h
    org.eclipse.emf.ecore.EClass ATTRIBUTE_IVALUE_CHANGE -> i
    org.eclipse.emf.ecore.EClass ATTRIBUTE_VALUE_CHANGE -> j
    org.eclipse.emf.ecore.EClass INDEXED_CHANGE -> k
    org.eclipse.emf.ecore.EAttribute INDEXED_CHANGE__POSITION -> l
    org.eclipse.emf.ecore.EClass ATTRIBUTE_IVALUE_NOT_IN_A -> m
    org.eclipse.emf.ecore.EClass ATTRIBUTE_VALUE_NOT_IN_A -> n
    org.eclipse.emf.ecore.EClass ATTRIBUTE_IVALUE_NOT_IN_B -> o
    org.eclipse.emf.ecore.EClass ATTRIBUTE_VALUE_NOT_IN_B -> p
    org.eclipse.emf.ecore.EClass ATTRIBUTE_VALUE_MOVE -> q
    org.eclipse.emf.ecore.EClass MOVE_CHANGE -> r
    org.eclipse.emf.ecore.EAttribute MOVE_CHANGE__POSITION_A -> s
    org.eclipse.emf.ecore.EAttribute MOVE_CHANGE__POSITION_B -> t
    org.eclipse.emf.ecore.EClass COMPLEX_OPERATION -> u
    org.eclipse.emf.ecore.EAttribute COMPLEX_OPERATION__NAME -> v
    org.eclipse.emf.ecore.EReference COMPLEX_OPERATION__CHANGES -> w
    org.eclipse.emf.ecore.EClass DELTA_MODEL -> x
    org.eclipse.emf.ecore.EReference DELTA_MODEL__CHANGES -> y
    org.eclipse.emf.ecore.EReference DELTA_MODEL__UNMATCHED_A -> z
    org.eclipse.emf.ecore.EReference DELTA_MODEL__UNMATCHED_B -> A
    org.eclipse.emf.ecore.EReference DELTA_MODEL__TASK -> B
    org.eclipse.emf.ecore.EReference DELTA_MODEL__UNCHANGED_ELEMENT -> C
    org.eclipse.emf.ecore.EClass UNMATCHED_ELEMENT -> D
    org.eclipse.emf.ecore.EReference UNMATCHED_ELEMENT__AFFECTED_CONTAINMENT -> E
    org.eclipse.emf.ecore.EReference UNMATCHED_ELEMENT__UNMATCHED_ELEMENT -> F
    org.eclipse.emf.ecore.EClass REFERENCE_CHANGE -> G
    org.eclipse.emf.ecore.EReference REFERENCE_CHANGE__EREFERENCE -> H
    org.eclipse.emf.ecore.EReference REFERENCE_CHANGE__TARGET_B -> I
    org.eclipse.emf.ecore.EReference REFERENCE_CHANGE__TARGET_A -> J
    org.eclipse.emf.ecore.EClass TASK -> K
    org.eclipse.emf.ecore.EReference TASK__DIFFERENCE -> L
    org.eclipse.emf.ecore.EReference TASK__TASK -> M
    org.eclipse.emf.ecore.EAttribute TASK__NAME -> N
    org.eclipse.emf.ecore.EAttribute TASK__BESCHREIBUNG -> O
    org.eclipse.emf.ecore.EClass UNCHANGED_ELEMENT -> P
    org.eclipse.emf.ecore.EReference UNCHANGED_ELEMENT__UNCHANGED_A -> Q
    org.eclipse.emf.ecore.EReference UNCHANGED_ELEMENT__UNCHANGED_B -> R
    org.eclipse.emf.ecore.EClass LOCAL_MOVE -> S
    org.eclipse.emf.ecore.EClass MOVE -> T
    org.eclipse.emf.ecore.EReference MOVE__REFERENCE_CHANGE_A -> U
    org.eclipse.emf.ecore.EReference MOVE__REFERENCE_CHANGE_B -> V
    org.eclipse.emf.ecore.EClass REFERENCE_INOT_IN_A -> W
    org.eclipse.emf.ecore.EClass REFERENCE_NOT_IN_A -> X
    org.eclipse.emf.ecore.EClass REFERENCE_INOT_IN_B -> Y
    org.eclipse.emf.ecore.EClass REFERENCE_NOT_IN_B -> Z
    org.eclipse.emf.ecore.EClass REFERENCE_ITARGET_CHANGE -> aa
    org.eclipse.emf.ecore.EClass REFERENCE_TARGET_CHANGE -> ab
org.sidiff.core.difference.model.IndexedChange -> org.sidiff.core.difference.model.IndexedChange:
    int getPosition() -> e
    void setPosition(int) -> a
org.sidiff.core.difference.model.LocalMove -> org.sidiff.core.difference.model.LocalMove:
org.sidiff.core.difference.model.Move -> org.sidiff.core.difference.model.Move:
    org.sidiff.core.difference.model.ReferenceChange getReferenceChangeA() -> e_
    void setReferenceChangeA(org.sidiff.core.difference.model.ReferenceChange) -> a
    org.sidiff.core.difference.model.ReferenceChange getReferenceChangeB() -> f_
    void setReferenceChangeB(org.sidiff.core.difference.model.ReferenceChange) -> b
org.sidiff.core.difference.model.MoveChange -> org.sidiff.core.difference.model.MoveChange:
    int getPositionA() -> e
    void setPositionA(int) -> a
    int getPositionB() -> g
    void setPositionB(int) -> b
org.sidiff.core.difference.model.ReferenceChange -> org.sidiff.core.difference.model.ReferenceChange:
    org.eclipse.emf.ecore.EReference getEReference() -> a_
    void setEReference(org.eclipse.emf.ecore.EReference) -> a
    org.eclipse.emf.ecore.EObject getTargetB() -> b_
    void setTargetB(org.eclipse.emf.ecore.EObject) -> c
    org.eclipse.emf.ecore.EObject getTargetA() -> f
    void setTargetA(org.eclipse.emf.ecore.EObject) -> d
org.sidiff.core.difference.model.ReferenceINotInA -> org.sidiff.core.difference.model.ReferenceINotInA:
org.sidiff.core.difference.model.ReferenceINotInB -> org.sidiff.core.difference.model.ReferenceINotInB:
org.sidiff.core.difference.model.ReferenceITargetChange -> org.sidiff.core.difference.model.ReferenceITargetChange:
org.sidiff.core.difference.model.ReferenceNotInA -> org.sidiff.core.difference.model.ReferenceNotInA:
org.sidiff.core.difference.model.ReferenceNotInB -> org.sidiff.core.difference.model.ReferenceNotInB:
org.sidiff.core.difference.model.ReferenceTargetChange -> org.sidiff.core.difference.model.ReferenceTargetChange:
org.sidiff.core.difference.model.Task -> org.sidiff.core.difference.model.Task:
    org.eclipse.emf.common.util.EList getDifference() -> a
    org.eclipse.emf.common.util.EList getTask() -> b
    java.lang.String getName() -> c
    void setName(java.lang.String) -> a
    java.lang.String getBeschreibung() -> d
    void setBeschreibung(java.lang.String) -> b
org.sidiff.core.difference.model.UnchangedElement -> org.sidiff.core.difference.model.UnchangedElement:
    org.eclipse.emf.ecore.EObject getUnchangedA() -> a
    void setUnchangedA(org.eclipse.emf.ecore.EObject) -> a
    org.eclipse.emf.ecore.EObject getUnchangedB() -> c
    void setUnchangedB(org.eclipse.emf.ecore.EObject) -> b
org.sidiff.core.difference.model.UnmatchedElement -> org.sidiff.core.difference.model.UnmatchedElement:
    org.sidiff.core.difference.model.ReferenceChange getAffectedContainment() -> a
    void setAffectedContainment(org.sidiff.core.difference.model.ReferenceChange) -> a
    org.eclipse.emf.ecore.EObject getUnmatchedElement() -> b
    void setUnmatchedElement(org.eclipse.emf.ecore.EObject) -> a
org.sidiff.core.difference.model.impl.AttributeChangeImpl -> org.sidiff.core.difference.model.impl.g:
    org.eclipse.emf.ecore.EAttribute eAttribute -> g
    java.lang.Object VALUE_A_EDEFAULT -> h
    java.lang.Object valueA -> i
    java.lang.Object VALUE_B_EDEFAULT -> j
    java.lang.Object valueB -> k
    org.eclipse.emf.ecore.EClass eStaticClass() -> eStaticClass
    org.eclipse.emf.ecore.EAttribute getEAttribute() -> c_
    org.eclipse.emf.ecore.EAttribute basicGetEAttribute() -> h
    void setEAttribute(org.eclipse.emf.ecore.EAttribute) -> a
    java.lang.Object getValueA() -> d_
    void setValueA(java.lang.Object) -> a
    java.lang.Object getValueB() -> f
    void setValueB(java.lang.Object) -> b
    java.lang.Object eGet(int,boolean,boolean) -> eGet
    void eSet(int,java.lang.Object) -> eSet
    void eUnset(int) -> eUnset
    boolean eIsSet(int) -> eIsSet
    java.lang.String toString() -> toString
org.sidiff.core.difference.model.impl.AttributeIValueChangeImpl -> org.sidiff.core.difference.model.impl.q:
    int POSITION_EDEFAULT -> c
    int position -> d
    org.eclipse.emf.ecore.EClass eStaticClass() -> eStaticClass
    int getPosition() -> e
    void setPosition(int) -> a
    java.lang.Object eGet(int,boolean,boolean) -> eGet
    void eSet(int,java.lang.Object) -> eSet
    void eUnset(int) -> eUnset
    boolean eIsSet(int) -> eIsSet
    int eBaseStructuralFeatureID(int,java.lang.Class) -> eBaseStructuralFeatureID
    int eDerivedStructuralFeatureID(int,java.lang.Class) -> eDerivedStructuralFeatureID
    java.lang.String toString() -> toString
org.sidiff.core.difference.model.impl.AttributeIValueNotInAImpl -> org.sidiff.core.difference.model.impl.A:
    int POSITION_EDEFAULT -> c
    int position -> d
    org.eclipse.emf.ecore.EClass eStaticClass() -> eStaticClass
    int getPosition() -> e
    void setPosition(int) -> a
    java.lang.Object eGet(int,boolean,boolean) -> eGet
    void eSet(int,java.lang.Object) -> eSet
    void eUnset(int) -> eUnset
    boolean eIsSet(int) -> eIsSet
    int eBaseStructuralFeatureID(int,java.lang.Class) -> eBaseStructuralFeatureID
    int eDerivedStructuralFeatureID(int,java.lang.Class) -> eDerivedStructuralFeatureID
    java.lang.String toString() -> toString
org.sidiff.core.difference.model.impl.AttributeIValueNotInBImpl -> org.sidiff.core.difference.model.impl.v:
    int POSITION_EDEFAULT -> c
    int position -> d
    org.eclipse.emf.ecore.EClass eStaticClass() -> eStaticClass
    int getPosition() -> e
    void setPosition(int) -> a
    java.lang.Object eGet(int,boolean,boolean) -> eGet
    void eSet(int,java.lang.Object) -> eSet
    void eUnset(int) -> eUnset
    boolean eIsSet(int) -> eIsSet
    int eBaseStructuralFeatureID(int,java.lang.Class) -> eBaseStructuralFeatureID
    int eDerivedStructuralFeatureID(int,java.lang.Class) -> eDerivedStructuralFeatureID
    java.lang.String toString() -> toString
org.sidiff.core.difference.model.impl.AttributeValueChangeImpl -> org.sidiff.core.difference.model.impl.s:
    org.eclipse.emf.ecore.EClass eStaticClass() -> eStaticClass
org.sidiff.core.difference.model.impl.AttributeValueMoveImpl -> org.sidiff.core.difference.model.impl.c:
    int POSITION_A_EDEFAULT -> c
    int positionA -> d
    int POSITION_B_EDEFAULT -> e
    int positionB -> f
    org.eclipse.emf.ecore.EClass eStaticClass() -> eStaticClass
    int getPositionA() -> e
    void setPositionA(int) -> a
    int getPositionB() -> g
    void setPositionB(int) -> b
    java.lang.Object eGet(int,boolean,boolean) -> eGet
    void eSet(int,java.lang.Object) -> eSet
    void eUnset(int) -> eUnset
    boolean eIsSet(int) -> eIsSet
    int eBaseStructuralFeatureID(int,java.lang.Class) -> eBaseStructuralFeatureID
    int eDerivedStructuralFeatureID(int,java.lang.Class) -> eDerivedStructuralFeatureID
    java.lang.String toString() -> toString
org.sidiff.core.difference.model.impl.AttributeValueNotInAImpl -> org.sidiff.core.difference.model.impl.j:
    org.eclipse.emf.ecore.EClass eStaticClass() -> eStaticClass
org.sidiff.core.difference.model.impl.AttributeValueNotInBImpl -> org.sidiff.core.difference.model.impl.z:
    org.eclipse.emf.ecore.EClass eStaticClass() -> eStaticClass
org.sidiff.core.difference.model.impl.ChangeImpl -> org.sidiff.core.difference.model.impl.a:
    org.eclipse.emf.ecore.EObject changedB -> a
    org.eclipse.emf.ecore.EObject changedA -> b
    org.eclipse.emf.ecore.EClass eStaticClass() -> eStaticClass
    org.eclipse.emf.ecore.EObject getChangedB() -> a
    org.eclipse.emf.ecore.EObject basicGetChangedB() -> b
    void setChangedB(org.eclipse.emf.ecore.EObject) -> a
    org.eclipse.emf.ecore.EObject getChangedA() -> c
    org.eclipse.emf.ecore.EObject basicGetChangedA() -> d
    void setChangedA(org.eclipse.emf.ecore.EObject) -> b
    java.lang.Object eGet(int,boolean,boolean) -> eGet
    void eSet(int,java.lang.Object) -> eSet
    void eUnset(int) -> eUnset
    boolean eIsSet(int) -> eIsSet
org.sidiff.core.difference.model.impl.ComplexOperationImpl -> org.sidiff.core.difference.model.impl.p:
    java.lang.String NAME_EDEFAULT -> a
    java.lang.String name -> b
    org.eclipse.emf.common.util.EList changes -> c
    org.eclipse.emf.ecore.EClass eStaticClass() -> eStaticClass
    java.lang.String getName() -> a
    void setName(java.lang.String) -> a
    org.eclipse.emf.common.util.EList getChanges() -> b
    org.eclipse.emf.common.notify.NotificationChain eInverseRemove(org.eclipse.emf.ecore.InternalEObject,int,org.eclipse.emf.common.notify.NotificationChain) -> eInverseRemove
    java.lang.Object eGet(int,boolean,boolean) -> eGet
    void eSet(int,java.lang.Object) -> eSet
    void eUnset(int) -> eUnset
    boolean eIsSet(int) -> eIsSet
    java.lang.String toString() -> toString
org.sidiff.core.difference.model.impl.DeltaModelImpl -> org.sidiff.core.difference.model.impl.x:
    org.eclipse.emf.common.util.EList changes -> a
    org.eclipse.emf.common.util.EList unmatchedA -> b
    org.eclipse.emf.common.util.EList unmatchedB -> c
    org.eclipse.emf.common.util.EList task -> d
    org.eclipse.emf.common.util.EList unchangedElement -> e
    org.eclipse.emf.ecore.EClass eStaticClass() -> eStaticClass
    org.eclipse.emf.common.util.EList getChanges() -> a
    org.eclipse.emf.common.util.EList getUnmatchedA() -> b
    org.eclipse.emf.common.util.EList getUnmatchedB() -> c
    org.eclipse.emf.common.util.EList getTask() -> d
    org.eclipse.emf.common.util.EList getUnchangedElement() -> e
    org.eclipse.emf.common.notify.NotificationChain eInverseRemove(org.eclipse.emf.ecore.InternalEObject,int,org.eclipse.emf.common.notify.NotificationChain) -> eInverseRemove
    java.lang.Object eGet(int,boolean,boolean) -> eGet
    void eSet(int,java.lang.Object) -> eSet
    void eUnset(int) -> eUnset
    boolean eIsSet(int) -> eIsSet
org.sidiff.core.difference.model.impl.DifferenceFactoryImpl -> org.sidiff.core.difference.model.impl.o:
    org.sidiff.core.difference.model.DifferenceFactory init() -> a
    org.eclipse.emf.ecore.EObject create(org.eclipse.emf.ecore.EClass) -> create
    org.sidiff.core.difference.model.AttributeIValueChange createAttributeIValueChange() -> b
    org.sidiff.core.difference.model.AttributeValueChange createAttributeValueChange() -> c
    org.sidiff.core.difference.model.AttributeIValueNotInA createAttributeIValueNotInA() -> d
    org.sidiff.core.difference.model.AttributeValueNotInA createAttributeValueNotInA() -> e
    org.sidiff.core.difference.model.AttributeIValueNotInB createAttributeIValueNotInB() -> f
    org.sidiff.core.difference.model.AttributeValueNotInB createAttributeValueNotInB() -> g
    org.sidiff.core.difference.model.AttributeValueMove createAttributeValueMove() -> h
    org.sidiff.core.difference.model.ComplexOperation createComplexOperation() -> i
    org.sidiff.core.difference.model.DeltaModel createDeltaModel() -> j
    org.sidiff.core.difference.model.UnmatchedElement createUnmatchedElement() -> k
    org.sidiff.core.difference.model.Task createTask() -> l
    org.sidiff.core.difference.model.UnchangedElement createUnchangedElement() -> m
    org.sidiff.core.difference.model.LocalMove createLocalMove() -> n
    org.sidiff.core.difference.model.Move createMove() -> o
    org.sidiff.core.difference.model.ReferenceINotInA createReferenceINotInA() -> p
    org.sidiff.core.difference.model.ReferenceNotInA createReferenceNotInA() -> q
    org.sidiff.core.difference.model.ReferenceINotInB createReferenceINotInB() -> r
    org.sidiff.core.difference.model.ReferenceNotInB createReferenceNotInB() -> s
    org.sidiff.core.difference.model.ReferenceITargetChange createReferenceITargetChange() -> t
    org.sidiff.core.difference.model.ReferenceTargetChange createReferenceTargetChange() -> u
    org.sidiff.core.difference.model.DifferencePackage getDifferencePackage() -> v
    org.sidiff.core.difference.model.DifferencePackage getPackage() -> w
org.sidiff.core.difference.model.impl.DifferenceImpl -> org.sidiff.core.difference.model.impl.r:
    org.eclipse.emf.ecore.EClass eStaticClass() -> eStaticClass
org.sidiff.core.difference.model.impl.DifferencePackageImpl -> org.sidiff.core.difference.model.impl.t:
    org.eclipse.emf.ecore.EClass attributeChangeEClass -> co
    org.eclipse.emf.ecore.EClass changeEClass -> cp
    org.eclipse.emf.ecore.EClass differenceEClass -> cq
    org.eclipse.emf.ecore.EClass attributeIValueChangeEClass -> cr
    org.eclipse.emf.ecore.EClass attributeValueChangeEClass -> cs
    org.eclipse.emf.ecore.EClass indexedChangeEClass -> ct
    org.eclipse.emf.ecore.EClass attributeIValueNotInAEClass -> cu
    org.eclipse.emf.ecore.EClass attributeValueNotInAEClass -> cv
    org.eclipse.emf.ecore.EClass attributeIValueNotInBEClass -> cw
    org.eclipse.emf.ecore.EClass attributeValueNotInBEClass -> cx
    org.eclipse.emf.ecore.EClass attributeValueMoveEClass -> cy
    org.eclipse.emf.ecore.EClass moveChangeEClass -> cz
    org.eclipse.emf.ecore.EClass complexOperationEClass -> cA
    org.eclipse.emf.ecore.EClass deltaModelEClass -> cB
    org.eclipse.emf.ecore.EClass unmatchedElementEClass -> cC
    org.eclipse.emf.ecore.EClass referenceChangeEClass -> cD
    org.eclipse.emf.ecore.EClass taskEClass -> cE
    org.eclipse.emf.ecore.EClass unchangedElementEClass -> cF
    org.eclipse.emf.ecore.EClass localMoveEClass -> cG
    org.eclipse.emf.ecore.EClass moveEClass -> cH
    org.eclipse.emf.ecore.EClass referenceINotInAEClass -> cI
    org.eclipse.emf.ecore.EClass referenceNotInAEClass -> cJ
    org.eclipse.emf.ecore.EClass referenceINotInBEClass -> cK
    org.eclipse.emf.ecore.EClass referenceNotInBEClass -> cL
    org.eclipse.emf.ecore.EClass referenceITargetChangeEClass -> cM
    org.eclipse.emf.ecore.EClass referenceTargetChangeEClass -> cN
    boolean isInited -> cO
    boolean isCreated -> cP
    boolean isInitialized -> cQ
    org.sidiff.core.difference.model.DifferencePackage init() -> ad
    org.eclipse.emf.ecore.EClass getAttributeChange() -> a
    org.eclipse.emf.ecore.EReference getAttributeChange_EAttribute() -> b
    org.eclipse.emf.ecore.EAttribute getAttributeChange_ValueA() -> c
    org.eclipse.emf.ecore.EAttribute getAttributeChange_ValueB() -> d
    org.eclipse.emf.ecore.EClass getChange() -> e
    org.eclipse.emf.ecore.EReference getChange_ChangedB() -> f
    org.eclipse.emf.ecore.EReference getChange_ChangedA() -> g
    org.eclipse.emf.ecore.EClass getDifference() -> h
    org.eclipse.emf.ecore.EClass getAttributeIValueChange() -> i
    org.eclipse.emf.ecore.EClass getAttributeValueChange() -> j
    org.eclipse.emf.ecore.EClass getIndexedChange() -> k
    org.eclipse.emf.ecore.EAttribute getIndexedChange_Position() -> l
    org.eclipse.emf.ecore.EClass getAttributeIValueNotInA() -> m
    org.eclipse.emf.ecore.EClass getAttributeValueNotInA() -> n
    org.eclipse.emf.ecore.EClass getAttributeIValueNotInB() -> o
    org.eclipse.emf.ecore.EClass getAttributeValueNotInB() -> p
    org.eclipse.emf.ecore.EClass getAttributeValueMove() -> q
    org.eclipse.emf.ecore.EClass getMoveChange() -> r
    org.eclipse.emf.ecore.EAttribute getMoveChange_PositionA() -> s
    org.eclipse.emf.ecore.EAttribute getMoveChange_PositionB() -> t
    org.eclipse.emf.ecore.EClass getComplexOperation() -> u
    org.eclipse.emf.ecore.EAttribute getComplexOperation_Name() -> v
    org.eclipse.emf.ecore.EReference getComplexOperation_Changes() -> w
    org.eclipse.emf.ecore.EClass getDeltaModel() -> x
    org.eclipse.emf.ecore.EReference getDeltaModel_Changes() -> y
    org.eclipse.emf.ecore.EReference getDeltaModel_UnmatchedA() -> z
    org.eclipse.emf.ecore.EReference getDeltaModel_UnmatchedB() -> A
    org.eclipse.emf.ecore.EReference getDeltaModel_Task() -> B
    org.eclipse.emf.ecore.EReference getDeltaModel_UnchangedElement() -> C
    org.eclipse.emf.ecore.EClass getUnmatchedElement() -> D
    org.eclipse.emf.ecore.EReference getUnmatchedElement_AffectedContainment() -> E
    org.eclipse.emf.ecore.EReference getUnmatchedElement_UnmatchedElement() -> F
    org.eclipse.emf.ecore.EClass getReferenceChange() -> G
    org.eclipse.emf.ecore.EReference getReferenceChange_EReference() -> H
    org.eclipse.emf.ecore.EReference getReferenceChange_TargetB() -> I
    org.eclipse.emf.ecore.EReference getReferenceChange_TargetA() -> J
    org.eclipse.emf.ecore.EClass getTask() -> K
    org.eclipse.emf.ecore.EReference getTask_Difference() -> L
    org.eclipse.emf.ecore.EReference getTask_Task() -> M
    org.eclipse.emf.ecore.EAttribute getTask_Name() -> N
    org.eclipse.emf.ecore.EAttribute getTask_Beschreibung() -> O
    org.eclipse.emf.ecore.EClass getUnchangedElement() -> P
    org.eclipse.emf.ecore.EReference getUnchangedElement_UnchangedA() -> Q
    org.eclipse.emf.ecore.EReference getUnchangedElement_UnchangedB() -> R
    org.eclipse.emf.ecore.EClass getLocalMove() -> S
    org.eclipse.emf.ecore.EClass getMove() -> T
    org.eclipse.emf.ecore.EReference getMove_ReferenceChangeA() -> U
    org.eclipse.emf.ecore.EReference getMove_ReferenceChangeB() -> V
    org.eclipse.emf.ecore.EClass getReferenceINotInA() -> W
    org.eclipse.emf.ecore.EClass getReferenceNotInA() -> X
    org.eclipse.emf.ecore.EClass getReferenceINotInB() -> Y
    org.eclipse.emf.ecore.EClass getReferenceNotInB() -> Z
    org.eclipse.emf.ecore.EClass getReferenceITargetChange() -> aa
    org.eclipse.emf.ecore.EClass getReferenceTargetChange() -> ab
    org.sidiff.core.difference.model.DifferenceFactory getDifferenceFactory() -> ac
    void createPackageContents() -> ae
    void initializePackageContents() -> af
    void createGenuineSiDiffModelAnnotations() -> ag
org.sidiff.core.difference.model.impl.IndexedChangeImpl -> org.sidiff.core.difference.model.impl.B:
    int POSITION_EDEFAULT -> a
    int position -> b
    org.eclipse.emf.ecore.EClass eStaticClass() -> eStaticClass
    int getPosition() -> e
    void setPosition(int) -> a
    java.lang.Object eGet(int,boolean,boolean) -> eGet
    void eSet(int,java.lang.Object) -> eSet
    void eUnset(int) -> eUnset
    boolean eIsSet(int) -> eIsSet
    java.lang.String toString() -> toString
org.sidiff.core.difference.model.impl.LocalMoveImpl -> org.sidiff.core.difference.model.impl.h:
    int POSITION_A_EDEFAULT -> c
    int positionA -> d
    int POSITION_B_EDEFAULT -> e
    int positionB -> f
    org.eclipse.emf.ecore.EClass eStaticClass() -> eStaticClass
    int getPositionA() -> e
    void setPositionA(int) -> a
    int getPositionB() -> g
    void setPositionB(int) -> b
    java.lang.Object eGet(int,boolean,boolean) -> eGet
    void eSet(int,java.lang.Object) -> eSet
    void eUnset(int) -> eUnset
    boolean eIsSet(int) -> eIsSet
    int eBaseStructuralFeatureID(int,java.lang.Class) -> eBaseStructuralFeatureID
    int eDerivedStructuralFeatureID(int,java.lang.Class) -> eDerivedStructuralFeatureID
    java.lang.String toString() -> toString
org.sidiff.core.difference.model.impl.MoveChangeImpl -> org.sidiff.core.difference.model.impl.n:
    int POSITION_A_EDEFAULT -> a
    int positionA -> b
    int POSITION_B_EDEFAULT -> c
    int positionB -> d
    org.eclipse.emf.ecore.EClass eStaticClass() -> eStaticClass
    int getPositionA() -> e
    void setPositionA(int) -> a
    int getPositionB() -> g
    void setPositionB(int) -> b
    java.lang.Object eGet(int,boolean,boolean) -> eGet
    void eSet(int,java.lang.Object) -> eSet
    void eUnset(int) -> eUnset
    boolean eIsSet(int) -> eIsSet
    java.lang.String toString() -> toString
org.sidiff.core.difference.model.impl.MoveImpl -> org.sidiff.core.difference.model.impl.m:
    org.sidiff.core.difference.model.ReferenceChange referenceChangeA -> c
    org.sidiff.core.difference.model.ReferenceChange referenceChangeB -> d
    org.eclipse.emf.ecore.EClass eStaticClass() -> eStaticClass
    org.sidiff.core.difference.model.ReferenceChange getReferenceChangeA() -> e_
    org.sidiff.core.difference.model.ReferenceChange basicGetReferenceChangeA() -> e
    void setReferenceChangeA(org.sidiff.core.difference.model.ReferenceChange) -> a
    org.sidiff.core.difference.model.ReferenceChange getReferenceChangeB() -> f_
    org.sidiff.core.difference.model.ReferenceChange basicGetReferenceChangeB() -> f
    void setReferenceChangeB(org.sidiff.core.difference.model.ReferenceChange) -> b
    java.lang.Object eGet(int,boolean,boolean) -> eGet
    void eSet(int,java.lang.Object) -> eSet
    void eUnset(int) -> eUnset
    boolean eIsSet(int) -> eIsSet
org.sidiff.core.difference.model.impl.ReferenceChangeImpl -> org.sidiff.core.difference.model.impl.w:
    org.eclipse.emf.ecore.EReference eReference -> g
    org.eclipse.emf.ecore.EObject targetB -> h
    org.eclipse.emf.ecore.EObject targetA -> i
    org.eclipse.emf.ecore.EClass eStaticClass() -> eStaticClass
    org.eclipse.emf.ecore.EReference getEReference() -> a_
    org.eclipse.emf.ecore.EReference basicGetEReference() -> h
    void setEReference(org.eclipse.emf.ecore.EReference) -> a
    org.eclipse.emf.ecore.EObject getTargetB() -> b_
    org.eclipse.emf.ecore.EObject basicGetTargetB() -> i
    void setTargetB(org.eclipse.emf.ecore.EObject) -> c
    org.eclipse.emf.ecore.EObject getTargetA() -> f
    org.eclipse.emf.ecore.EObject basicGetTargetA() -> j
    void setTargetA(org.eclipse.emf.ecore.EObject) -> d
    java.lang.Object eGet(int,boolean,boolean) -> eGet
    void eSet(int,java.lang.Object) -> eSet
    void eUnset(int) -> eUnset
    boolean eIsSet(int) -> eIsSet
org.sidiff.core.difference.model.impl.ReferenceINotInAImpl -> org.sidiff.core.difference.model.impl.e:
    int POSITION_EDEFAULT -> c
    int position -> d
    org.eclipse.emf.ecore.EClass eStaticClass() -> eStaticClass
    int getPosition() -> e
    void setPosition(int) -> a
    java.lang.Object eGet(int,boolean,boolean) -> eGet
    void eSet(int,java.lang.Object) -> eSet
    void eUnset(int) -> eUnset
    boolean eIsSet(int) -> eIsSet
    int eBaseStructuralFeatureID(int,java.lang.Class) -> eBaseStructuralFeatureID
    int eDerivedStructuralFeatureID(int,java.lang.Class) -> eDerivedStructuralFeatureID
    java.lang.String toString() -> toString
org.sidiff.core.difference.model.impl.ReferenceINotInBImpl -> org.sidiff.core.difference.model.impl.i:
    int POSITION_EDEFAULT -> c
    int position -> d
    org.eclipse.emf.ecore.EClass eStaticClass() -> eStaticClass
    int getPosition() -> e
    void setPosition(int) -> a
    java.lang.Object eGet(int,boolean,boolean) -> eGet
    void eSet(int,java.lang.Object) -> eSet
    void eUnset(int) -> eUnset
    boolean eIsSet(int) -> eIsSet
    int eBaseStructuralFeatureID(int,java.lang.Class) -> eBaseStructuralFeatureID
    int eDerivedStructuralFeatureID(int,java.lang.Class) -> eDerivedStructuralFeatureID
    java.lang.String toString() -> toString
org.sidiff.core.difference.model.impl.ReferenceITargetChangeImpl -> org.sidiff.core.difference.model.impl.b:
    int POSITION_EDEFAULT -> c
    int position -> d
    org.eclipse.emf.ecore.EClass eStaticClass() -> eStaticClass
    int getPosition() -> e
    void setPosition(int) -> a
    java.lang.Object eGet(int,boolean,boolean) -> eGet
    void eSet(int,java.lang.Object) -> eSet
    void eUnset(int) -> eUnset
    boolean eIsSet(int) -> eIsSet
    int eBaseStructuralFeatureID(int,java.lang.Class) -> eBaseStructuralFeatureID
    int eDerivedStructuralFeatureID(int,java.lang.Class) -> eDerivedStructuralFeatureID
    java.lang.String toString() -> toString
org.sidiff.core.difference.model.impl.ReferenceNotInAImpl -> org.sidiff.core.difference.model.impl.d:
    org.eclipse.emf.ecore.EClass eStaticClass() -> eStaticClass
org.sidiff.core.difference.model.impl.ReferenceNotInBImpl -> org.sidiff.core.difference.model.impl.y:
    org.eclipse.emf.ecore.EClass eStaticClass() -> eStaticClass
org.sidiff.core.difference.model.impl.ReferenceTargetChangeImpl -> org.sidiff.core.difference.model.impl.f:
    org.eclipse.emf.ecore.EClass eStaticClass() -> eStaticClass
org.sidiff.core.difference.model.impl.TaskImpl -> org.sidiff.core.difference.model.impl.l:
    org.eclipse.emf.common.util.EList difference -> a
    org.eclipse.emf.common.util.EList task -> b
    java.lang.String NAME_EDEFAULT -> c
    java.lang.String name -> d
    java.lang.String BESCHREIBUNG_EDEFAULT -> e
    java.lang.String beschreibung -> f
    org.eclipse.emf.ecore.EClass eStaticClass() -> eStaticClass
    org.eclipse.emf.common.util.EList getDifference() -> a
    org.eclipse.emf.common.util.EList getTask() -> b
    java.lang.String getName() -> c
    void setName(java.lang.String) -> a
    java.lang.String getBeschreibung() -> d
    void setBeschreibung(java.lang.String) -> b
    org.eclipse.emf.common.notify.NotificationChain eInverseRemove(org.eclipse.emf.ecore.InternalEObject,int,org.eclipse.emf.common.notify.NotificationChain) -> eInverseRemove
    java.lang.Object eGet(int,boolean,boolean) -> eGet
    void eSet(int,java.lang.Object) -> eSet
    void eUnset(int) -> eUnset
    boolean eIsSet(int) -> eIsSet
    java.lang.String toString() -> toString
org.sidiff.core.difference.model.impl.UnchangedElementImpl -> org.sidiff.core.difference.model.impl.u:
    org.eclipse.emf.ecore.EObject unchangedA -> a
    org.eclipse.emf.ecore.EObject unchangedB -> b
    org.eclipse.emf.ecore.EClass eStaticClass() -> eStaticClass
    org.eclipse.emf.ecore.EObject getUnchangedA() -> a
    org.eclipse.emf.ecore.EObject basicGetUnchangedA() -> b
    void setUnchangedA(org.eclipse.emf.ecore.EObject) -> a
    org.eclipse.emf.ecore.EObject getUnchangedB() -> c
    org.eclipse.emf.ecore.EObject basicGetUnchangedB() -> d
    void setUnchangedB(org.eclipse.emf.ecore.EObject) -> b
    java.lang.Object eGet(int,boolean,boolean) -> eGet
    void eSet(int,java.lang.Object) -> eSet
    void eUnset(int) -> eUnset
    boolean eIsSet(int) -> eIsSet
org.sidiff.core.difference.model.impl.UnmatchedElementImpl -> org.sidiff.core.difference.model.impl.k:
    org.sidiff.core.difference.model.ReferenceChange affectedContainment -> a
    org.eclipse.emf.ecore.EObject unmatchedElement -> b
    org.eclipse.emf.ecore.EClass eStaticClass() -> eStaticClass
    org.sidiff.core.difference.model.ReferenceChange getAffectedContainment() -> a
    org.sidiff.core.difference.model.ReferenceChange basicGetAffectedContainment() -> c
    void setAffectedContainment(org.sidiff.core.difference.model.ReferenceChange) -> a
    org.eclipse.emf.ecore.EObject getUnmatchedElement() -> b
    org.eclipse.emf.ecore.EObject basicGetUnmatchedElement() -> d
    void setUnmatchedElement(org.eclipse.emf.ecore.EObject) -> a
    java.lang.Object eGet(int,boolean,boolean) -> eGet
    void eSet(int,java.lang.Object) -> eSet
    void eUnset(int) -> eUnset
    boolean eIsSet(int) -> eIsSet
org.sidiff.core.difference.model.util.DifferenceAdapterFactory -> org.sidiff.core.difference.model.util.b:
    org.sidiff.core.difference.model.DifferencePackage modelPackage -> a
    org.sidiff.core.difference.model.util.DifferenceSwitch modelSwitch -> b
    boolean isFactoryForType(java.lang.Object) -> isFactoryForType
    org.eclipse.emf.common.notify.Adapter createAdapter(org.eclipse.emf.common.notify.Notifier) -> createAdapter
    org.eclipse.emf.common.notify.Adapter createAttributeChangeAdapter() -> a
    org.eclipse.emf.common.notify.Adapter createChangeAdapter() -> b
    org.eclipse.emf.common.notify.Adapter createDifferenceAdapter() -> c
    org.eclipse.emf.common.notify.Adapter createAttributeIValueChangeAdapter() -> d
    org.eclipse.emf.common.notify.Adapter createAttributeValueChangeAdapter() -> e
    org.eclipse.emf.common.notify.Adapter createIndexedChangeAdapter() -> f
    org.eclipse.emf.common.notify.Adapter createAttributeIValueNotInAAdapter() -> g
    org.eclipse.emf.common.notify.Adapter createAttributeValueNotInAAdapter() -> h
    org.eclipse.emf.common.notify.Adapter createAttributeIValueNotInBAdapter() -> i
    org.eclipse.emf.common.notify.Adapter createAttributeValueNotInBAdapter() -> j
    org.eclipse.emf.common.notify.Adapter createAttributeValueMoveAdapter() -> k
    org.eclipse.emf.common.notify.Adapter createMoveChangeAdapter() -> l
    org.eclipse.emf.common.notify.Adapter createComplexOperationAdapter() -> m
    org.eclipse.emf.common.notify.Adapter createDeltaModelAdapter() -> n
    org.eclipse.emf.common.notify.Adapter createUnmatchedElementAdapter() -> o
    org.eclipse.emf.common.notify.Adapter createReferenceChangeAdapter() -> p
    org.eclipse.emf.common.notify.Adapter createTaskAdapter() -> q
    org.eclipse.emf.common.notify.Adapter createUnchangedElementAdapter() -> r
    org.eclipse.emf.common.notify.Adapter createLocalMoveAdapter() -> s
    org.eclipse.emf.common.notify.Adapter createMoveAdapter() -> t
    org.eclipse.emf.common.notify.Adapter createReferenceINotInAAdapter() -> u
    org.eclipse.emf.common.notify.Adapter createReferenceNotInAAdapter() -> v
    org.eclipse.emf.common.notify.Adapter createReferenceINotInBAdapter() -> w
    org.eclipse.emf.common.notify.Adapter createReferenceNotInBAdapter() -> x
    org.eclipse.emf.common.notify.Adapter createReferenceITargetChangeAdapter() -> y
    org.eclipse.emf.common.notify.Adapter createReferenceTargetChangeAdapter() -> z
    org.eclipse.emf.common.notify.Adapter createEObjectAdapter() -> A
org.sidiff.core.difference.model.util.DifferenceAdapterFactory$1 -> org.sidiff.core.difference.model.util.c:
    org.sidiff.core.difference.model.util.DifferenceAdapterFactory this$0 -> b
    org.eclipse.emf.common.notify.Adapter caseAttributeChange(org.sidiff.core.difference.model.AttributeChange) -> b
    org.eclipse.emf.common.notify.Adapter caseChange(org.sidiff.core.difference.model.Change) -> b
    org.eclipse.emf.common.notify.Adapter caseDifference(org.sidiff.core.difference.model.Difference) -> b
    org.eclipse.emf.common.notify.Adapter caseAttributeIValueChange(org.sidiff.core.difference.model.AttributeIValueChange) -> b
    org.eclipse.emf.common.notify.Adapter caseAttributeValueChange(org.sidiff.core.difference.model.AttributeValueChange) -> b
    org.eclipse.emf.common.notify.Adapter caseIndexedChange(org.sidiff.core.difference.model.IndexedChange) -> b
    org.eclipse.emf.common.notify.Adapter caseAttributeIValueNotInA(org.sidiff.core.difference.model.AttributeIValueNotInA) -> b
    org.eclipse.emf.common.notify.Adapter caseAttributeValueNotInA(org.sidiff.core.difference.model.AttributeValueNotInA) -> b
    org.eclipse.emf.common.notify.Adapter caseAttributeIValueNotInB(org.sidiff.core.difference.model.AttributeIValueNotInB) -> b
    org.eclipse.emf.common.notify.Adapter caseAttributeValueNotInB(org.sidiff.core.difference.model.AttributeValueNotInB) -> b
    org.eclipse.emf.common.notify.Adapter caseAttributeValueMove(org.sidiff.core.difference.model.AttributeValueMove) -> b
    org.eclipse.emf.common.notify.Adapter caseMoveChange(org.sidiff.core.difference.model.MoveChange) -> b
    org.eclipse.emf.common.notify.Adapter caseComplexOperation(org.sidiff.core.difference.model.ComplexOperation) -> b
    org.eclipse.emf.common.notify.Adapter caseDeltaModel(org.sidiff.core.difference.model.DeltaModel) -> b
    org.eclipse.emf.common.notify.Adapter caseUnmatchedElement(org.sidiff.core.difference.model.UnmatchedElement) -> b
    org.eclipse.emf.common.notify.Adapter caseReferenceChange(org.sidiff.core.difference.model.ReferenceChange) -> b
    org.eclipse.emf.common.notify.Adapter caseTask(org.sidiff.core.difference.model.Task) -> b
    org.eclipse.emf.common.notify.Adapter caseUnchangedElement(org.sidiff.core.difference.model.UnchangedElement) -> b
    org.eclipse.emf.common.notify.Adapter caseLocalMove(org.sidiff.core.difference.model.LocalMove) -> b
    org.eclipse.emf.common.notify.Adapter caseMove(org.sidiff.core.difference.model.Move) -> b
    org.eclipse.emf.common.notify.Adapter caseReferenceINotInA(org.sidiff.core.difference.model.ReferenceINotInA) -> b
    org.eclipse.emf.common.notify.Adapter caseReferenceNotInA(org.sidiff.core.difference.model.ReferenceNotInA) -> b
    org.eclipse.emf.common.notify.Adapter caseReferenceINotInB(org.sidiff.core.difference.model.ReferenceINotInB) -> b
    org.eclipse.emf.common.notify.Adapter caseReferenceNotInB(org.sidiff.core.difference.model.ReferenceNotInB) -> b
    org.eclipse.emf.common.notify.Adapter caseReferenceITargetChange(org.sidiff.core.difference.model.ReferenceITargetChange) -> b
    org.eclipse.emf.common.notify.Adapter caseReferenceTargetChange(org.sidiff.core.difference.model.ReferenceTargetChange) -> b
    org.eclipse.emf.common.notify.Adapter defaultCase(org.eclipse.emf.ecore.EObject) -> c
    java.lang.Object caseMove(org.sidiff.core.difference.model.Move) -> a
    java.lang.Object caseUnmatchedElement(org.sidiff.core.difference.model.UnmatchedElement) -> a
    java.lang.Object caseAttributeChange(org.sidiff.core.difference.model.AttributeChange) -> a
    java.lang.Object caseAttributeValueNotInA(org.sidiff.core.difference.model.AttributeValueNotInA) -> a
    java.lang.Object caseAttributeIValueNotInA(org.sidiff.core.difference.model.AttributeIValueNotInA) -> a
    java.lang.Object caseAttributeValueMove(org.sidiff.core.difference.model.AttributeValueMove) -> a
    java.lang.Object caseReferenceINotInB(org.sidiff.core.difference.model.ReferenceINotInB) -> a
    java.lang.Object defaultCase(org.eclipse.emf.ecore.EObject) -> b
    java.lang.Object caseAttributeValueChange(org.sidiff.core.difference.model.AttributeValueChange) -> a
    java.lang.Object caseAttributeIValueChange(org.sidiff.core.difference.model.AttributeIValueChange) -> a
    java.lang.Object caseDifference(org.sidiff.core.difference.model.Difference) -> a
    java.lang.Object caseReferenceNotInA(org.sidiff.core.difference.model.ReferenceNotInA) -> a
    java.lang.Object caseAttributeValueNotInB(org.sidiff.core.difference.model.AttributeValueNotInB) -> a
    java.lang.Object caseComplexOperation(org.sidiff.core.difference.model.ComplexOperation) -> a
    java.lang.Object caseDeltaModel(org.sidiff.core.difference.model.DeltaModel) -> a
    java.lang.Object caseAttributeIValueNotInB(org.sidiff.core.difference.model.AttributeIValueNotInB) -> a
    java.lang.Object caseReferenceITargetChange(org.sidiff.core.difference.model.ReferenceITargetChange) -> a
    java.lang.Object caseReferenceChange(org.sidiff.core.difference.model.ReferenceChange) -> a
    java.lang.Object caseTask(org.sidiff.core.difference.model.Task) -> a
    java.lang.Object caseReferenceTargetChange(org.sidiff.core.difference.model.ReferenceTargetChange) -> a
    java.lang.Object caseMoveChange(org.sidiff.core.difference.model.MoveChange) -> a
    java.lang.Object caseUnchangedElement(org.sidiff.core.difference.model.UnchangedElement) -> a
    java.lang.Object caseReferenceNotInB(org.sidiff.core.difference.model.ReferenceNotInB) -> a
    java.lang.Object caseChange(org.sidiff.core.difference.model.Change) -> a
    java.lang.Object caseLocalMove(org.sidiff.core.difference.model.LocalMove) -> a
    java.lang.Object caseIndexedChange(org.sidiff.core.difference.model.IndexedChange) -> a
    java.lang.Object caseReferenceINotInA(org.sidiff.core.difference.model.ReferenceINotInA) -> a
org.sidiff.core.difference.model.util.DifferenceSwitch -> org.sidiff.core.difference.model.util.a:
    org.sidiff.core.difference.model.DifferencePackage modelPackage -> a
    java.lang.Object doSwitch(org.eclipse.emf.ecore.EObject) -> a
    java.lang.Object doSwitch(org.eclipse.emf.ecore.EClass,org.eclipse.emf.ecore.EObject) -> a
    java.lang.Object doSwitch(int,org.eclipse.emf.ecore.EObject) -> a
    java.lang.Object caseAttributeChange(org.sidiff.core.difference.model.AttributeChange) -> a
    java.lang.Object caseChange(org.sidiff.core.difference.model.Change) -> a
    java.lang.Object caseDifference(org.sidiff.core.difference.model.Difference) -> a
    java.lang.Object caseAttributeIValueChange(org.sidiff.core.difference.model.AttributeIValueChange) -> a
    java.lang.Object caseAttributeValueChange(org.sidiff.core.difference.model.AttributeValueChange) -> a
    java.lang.Object caseIndexedChange(org.sidiff.core.difference.model.IndexedChange) -> a
    java.lang.Object caseAttributeIValueNotInA(org.sidiff.core.difference.model.AttributeIValueNotInA) -> a
    java.lang.Object caseAttributeValueNotInA(org.sidiff.core.difference.model.AttributeValueNotInA) -> a
    java.lang.Object caseAttributeIValueNotInB(org.sidiff.core.difference.model.AttributeIValueNotInB) -> a
    java.lang.Object caseAttributeValueNotInB(org.sidiff.core.difference.model.AttributeValueNotInB) -> a
    java.lang.Object caseAttributeValueMove(org.sidiff.core.difference.model.AttributeValueMove) -> a
    java.lang.Object caseMoveChange(org.sidiff.core.difference.model.MoveChange) -> a
    java.lang.Object caseComplexOperation(org.sidiff.core.difference.model.ComplexOperation) -> a
    java.lang.Object caseDeltaModel(org.sidiff.core.difference.model.DeltaModel) -> a
    java.lang.Object caseUnmatchedElement(org.sidiff.core.difference.model.UnmatchedElement) -> a
    java.lang.Object caseReferenceChange(org.sidiff.core.difference.model.ReferenceChange) -> a
    java.lang.Object caseTask(org.sidiff.core.difference.model.Task) -> a
    java.lang.Object caseUnchangedElement(org.sidiff.core.difference.model.UnchangedElement) -> a
    java.lang.Object caseLocalMove(org.sidiff.core.difference.model.LocalMove) -> a
    java.lang.Object caseMove(org.sidiff.core.difference.model.Move) -> a
    java.lang.Object caseReferenceINotInA(org.sidiff.core.difference.model.ReferenceINotInA) -> a
    java.lang.Object caseReferenceNotInA(org.sidiff.core.difference.model.ReferenceNotInA) -> a
    java.lang.Object caseReferenceINotInB(org.sidiff.core.difference.model.ReferenceINotInB) -> a
    java.lang.Object caseReferenceNotInB(org.sidiff.core.difference.model.ReferenceNotInB) -> a
    java.lang.Object caseReferenceITargetChange(org.sidiff.core.difference.model.ReferenceITargetChange) -> a
    java.lang.Object caseReferenceTargetChange(org.sidiff.core.difference.model.ReferenceTargetChange) -> a
    java.lang.Object defaultCase(org.eclipse.emf.ecore.EObject) -> b
org.sidiff.core.difference.symmetric.Activator -> org.sidiff.core.difference.symmetric.e:
    void start(org.osgi.framework.BundleContext) -> start
    void stop(org.osgi.framework.BundleContext) -> stop
    org.sidiff.core.difference.symmetric.SymmetricDifferenceService createInstance() -> b
    java.lang.Object createInstance() -> a
org.sidiff.core.difference.symmetric.Difference -> org.sidiff.core.difference.symmetric.Difference:
    org.eclipse.emf.ecore.EClass getElementType() -> b
    org.eclipse.emf.ecore.EObject getElementInModel(org.eclipse.emf.ecore.resource.Resource) -> b
    java.util.Collection getElements() -> c
org.sidiff.core.difference.symmetric.DifferenceCalculator -> org.sidiff.core.difference.symmetric.DifferenceCalculator:
    java.util.Collection computeDifferences(java.util.List,org.sidiff.core.correspondences.CorrespondencesService,org.eclipse.emf.ecore.resource.Resource[]) -> a
org.sidiff.core.difference.symmetric.DifferenceUtils -> org.sidiff.core.difference.symmetric.a:
    org.sidiff.common.collections.Classifier DIFFERENCE_BY_TYPE -> a
    java.util.Map classifyDifferencesByElements(java.util.Collection) -> a
    org.sidiff.common.collections.Selector createDiffTypeSelector(java.lang.Class) -> a
org.sidiff.core.difference.symmetric.DifferenceUtils$1 -> org.sidiff.core.difference.symmetric.d:
    java.lang.Class classify(org.sidiff.core.difference.symmetric.Difference) -> a
    java.lang.Object classify(java.lang.Object) -> a
org.sidiff.core.difference.symmetric.DifferenceUtils$2 -> org.sidiff.core.difference.symmetric.c:
    java.lang.Class val$difftype -> a
    boolean select(org.sidiff.core.difference.symmetric.Difference) -> a
    boolean select(java.lang.Object) -> a
org.sidiff.core.difference.symmetric.Equals -> org.sidiff.core.difference.symmetric.Equals:
org.sidiff.core.difference.symmetric.Move -> org.sidiff.core.difference.symmetric.Move:
    org.eclipse.emf.ecore.EObject getParentInModel(org.eclipse.emf.ecore.resource.Resource) -> a
org.sidiff.core.difference.symmetric.Reference -> org.sidiff.core.difference.symmetric.Reference:
    org.eclipse.emf.ecore.EReference getReference() -> a
    java.util.List getTargetsInModel(org.eclipse.emf.ecore.resource.Resource) -> a
org.sidiff.core.difference.symmetric.SimpleDiffSerializer -> org.sidiff.core.difference.symmetric.b:
    java.lang.String ATTR_ROOT_TITLE_VALUE -> b
    java.lang.String DTD -> c
    java.lang.String ELEMENT_ROOT -> d
    java.lang.String ATTR_ROOT_TITLE -> e
    java.lang.String ELEMENT_DOCUMENTS -> f
    java.lang.String ELEMENT_DOCUMENT -> g
    java.lang.String ATTR_DOCUMENT_DOCID -> h
    java.lang.String ATTR_DOCUMENT_FILENAME -> i
    java.lang.String ELEMENT_DIFFERENCES -> j
    java.lang.String ELEMENT_NODE -> k
    java.lang.String ATTR_NODE_NODEID -> l
    java.lang.String ATTR_NODE_DOCID -> m
    java.lang.String ATTR_NODE_ROLE -> n
    java.lang.String ELEMENT_UPDATE -> o
    java.lang.String ATTR_UPDATE_ATTRIBUTENAME -> p
    java.lang.String ELEMENT_MOVE -> q
    java.lang.String ELEMENT_STRUCTURAL -> r
    java.lang.String ELEMENT_EQUAL -> s
    java.lang.String ELEMENT_REFERENCE -> t
    java.lang.String ATTR_REFERENCE_NAME -> u
    java.lang.String ELEMENT_REFERECEDESCRIPTION -> v
    java.lang.String ROLE_ESU -> w
    java.lang.String ROLE_REF_S -> x
    java.lang.String ROLE_REF_T -> y
    java.lang.String ROLE_MOVE_S -> z
    java.lang.String ROLE_MOVE_D -> A
    org.sidiff.common.xml.XMLWriter xmlwriter -> B
    java.util.Map root_title -> C
    boolean summarizeStructurals -> D
    boolean $assertionsDisabled -> a
    boolean isSummarizeStructurals() -> a
    void setSummarizeStructurals(boolean) -> a
    void serialize(java.io.OutputStream,org.sidiff.core.difference.symmetric.SymmetricDifferenceService) -> a
    void createDocumentEntry(org.eclipse.emf.ecore.resource.Resource,int) -> a
    void createEqualsEntry(org.sidiff.core.difference.symmetric.Equals,java.util.ArrayList) -> a
    void createUpdateEntry(org.sidiff.core.difference.symmetric.Update,java.util.ArrayList) -> a
    void createReferenceEntry(org.sidiff.core.difference.symmetric.Reference,java.util.ArrayList) -> a
    void createMoveEntry(org.sidiff.core.difference.symmetric.Move,java.util.ArrayList) -> a
    void createStructuralEntry(org.sidiff.core.difference.symmetric.Structural,java.util.ArrayList) -> a
    void serialize(java.io.OutputStream,java.lang.Object) -> a
org.sidiff.core.difference.symmetric.Structural -> org.sidiff.core.difference.symmetric.Structural:
    boolean isInModel(org.eclipse.emf.ecore.resource.Resource) -> a
org.sidiff.core.difference.symmetric.SymmetricDifferenceService -> org.sidiff.core.difference.symmetric.SymmetricDifferenceService:
    void serialize(java.io.OutputStream,org.sidiff.common.io.Serializer) -> a
    java.util.Collection getAllDifferences() -> b
    java.util.Collection getAllDifferences(org.eclipse.emf.ecore.EObject) -> b
    java.util.Collection getDifferences(org.eclipse.emf.ecore.EObject) -> a
    java.util.Collection getUpdates() -> g
    java.util.Collection getEquals() -> c
    java.util.Collection getStructurals() -> f
    java.util.Collection getMoves() -> d
    java.util.Collection getReferences() -> e
    org.eclipse.emf.ecore.resource.Resource[] getModels() -> a
org.sidiff.core.difference.symmetric.SymmetricDifferenceServiceProvider -> org.sidiff.core.difference.symmetric.SymmetricDifferenceServiceProvider:
org.sidiff.core.difference.symmetric.Update -> org.sidiff.core.difference.symmetric.Update:
    org.eclipse.emf.ecore.EAttribute getAttribute() -> a
    java.lang.Object getValueInModel(org.eclipse.emf.ecore.resource.Resource) -> a
org.sidiff.core.difference.symmetric.impl.AbstractDifferenceImpl -> org.sidiff.core.difference.symmetric.impl.c:
    java.util.List elements -> a
    org.eclipse.emf.ecore.EClass getElementType() -> b
    org.eclipse.emf.ecore.EObject getElementInModel(org.eclipse.emf.ecore.resource.Resource) -> b
    java.util.Collection getElements() -> c
    boolean equals(java.lang.Object) -> equals
org.sidiff.core.difference.symmetric.impl.EqualsImpl -> org.sidiff.core.difference.symmetric.impl.f:
    org.eclipse.emf.ecore.EObject getElementInModel(org.eclipse.emf.ecore.resource.Resource) -> b
    java.lang.String toString() -> toString
    boolean equals(java.lang.Object) -> equals
org.sidiff.core.difference.symmetric.impl.MoveImpl -> org.sidiff.core.difference.symmetric.impl.b:
    org.eclipse.emf.ecore.EObject getParentInModel(org.eclipse.emf.ecore.resource.Resource) -> a
    java.lang.String toString() -> toString
    boolean equals(java.lang.Object) -> equals
org.sidiff.core.difference.symmetric.impl.ReferenceImpl -> org.sidiff.core.difference.symmetric.impl.e:
    org.eclipse.emf.ecore.EReference reference -> b
    org.eclipse.emf.ecore.EReference getReference() -> a
    java.util.List getTargetsInModel(org.eclipse.emf.ecore.resource.Resource) -> a
    java.lang.String toString() -> toString
    boolean equals(java.lang.Object) -> equals
org.sidiff.core.difference.symmetric.impl.StructuralImpl -> org.sidiff.core.difference.symmetric.impl.h:
    boolean isInModel(org.eclipse.emf.ecore.resource.Resource) -> a
    java.lang.String toString() -> toString
org.sidiff.core.difference.symmetric.impl.SymmetricDifferenceServiceImpl -> org.sidiff.core.difference.symmetric.impl.d:
    org.sidiff.core.correspondences.CorrespondencesService correspondencesService -> b
    org.eclipse.emf.ecore.resource.Resource[] models -> c
    org.sidiff.core.difference.symmetric.DifferenceCalculator calculator -> d
    boolean $assertionsDisabled -> a
    void initialize(org.sidiff.common.services.ServiceContext,java.lang.Object[]) -> a
    org.eclipse.emf.ecore.resource.Resource[] getModels() -> a
    java.util.Collection getAllDifferences() -> b
    java.util.Collection getDifferences(org.eclipse.emf.ecore.EObject) -> a
    java.util.Collection getAllDifferences(org.eclipse.emf.ecore.EObject) -> b
    java.util.Collection getEquals() -> c
    java.util.Collection getMoves() -> d
    java.util.Collection getReferences() -> e
    java.util.Collection getStructurals() -> f
    java.util.Collection getUpdates() -> g
    void serialize(java.io.OutputStream,org.sidiff.common.io.Serializer) -> a
org.sidiff.core.difference.symmetric.impl.TwoWayDifferenceCalculator -> org.sidiff.core.difference.symmetric.impl.g:
    java.util.Collection computeDifferences(java.util.List,org.sidiff.core.correspondences.CorrespondencesService,org.eclipse.emf.ecore.resource.Resource[]) -> a
    java.util.List differentAttributes(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject) -> a
    java.util.List differentReferences(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject,org.sidiff.core.correspondences.CorrespondencesService,org.eclipse.emf.ecore.resource.Resource[]) -> a
    boolean equalSets(java.util.List,java.util.List,org.sidiff.core.correspondences.CorrespondencesService,org.eclipse.emf.ecore.resource.Resource[]) -> a
org.sidiff.core.difference.symmetric.impl.UpdateImpl -> org.sidiff.core.difference.symmetric.impl.a:
    org.eclipse.emf.ecore.EAttribute attribute -> b
    org.eclipse.emf.ecore.EAttribute getAttribute() -> a
    java.lang.Object getValueInModel(org.eclipse.emf.ecore.resource.Resource) -> a
    java.lang.String toString() -> toString
    boolean equals(java.lang.Object) -> equals
org.sidiff.core.matching.HashMatchingService -> org.sidiff.core.matching.HashMatchingService:
org.sidiff.core.matching.HashMatchingServiceProvider -> org.sidiff.core.matching.HashMatchingServiceProvider:
org.sidiff.core.matching.IDBasedMatchingService -> org.sidiff.core.matching.IDBasedMatchingService:
org.sidiff.core.matching.IDBasedMatchingServiceProvider -> org.sidiff.core.matching.IDBasedMatchingServiceProvider:
org.sidiff.core.matching.IterativeMatchingEvent -> org.sidiff.core.matching.b:
    long serialVersionUID -> f
    int NEW_ROUND_STARTED -> a
    int SWITCHED_INTO_TOPDOWN -> b
    int SWITCHED_INTO_BOTTOMUP -> c
    int NEW_ROUND_NUMBER_FEATURE -> d
    int SWITCHED_MATCHER_FEATURE -> e
org.sidiff.core.matching.IterativeMatchingService -> org.sidiff.core.matching.IterativeMatchingService:
org.sidiff.core.matching.IterativeMatchingServiceProvider -> org.sidiff.core.matching.IterativeMatchingServiceProvider:
org.sidiff.core.matching.MatchingEvent -> org.sidiff.core.matching.a:
    long serialVersionUID -> e
    int MATCH_CREATED_EVENT -> a
    int MATCH_REVOKED_EVENT -> b
    int MATCHED_ELEMENT_A_FEATURE -> c
    int MATCHED_ELEMENT_B_FEATURE -> d
org.sidiff.core.matching.MatchingService -> org.sidiff.core.matching.MatchingService:
    void match() -> a
org.sidiff.core.matching.MatchingServiceProvider -> org.sidiff.core.matching.MatchingServiceProvider:
org.sidiff.core.matching.hashing.Activator -> org.sidiff.core.matching.hashing.a:
    void start(org.osgi.framework.BundleContext) -> start
    void stop(org.osgi.framework.BundleContext) -> stop
org.sidiff.core.matching.hashing.HashMatchingServiceImpl -> org.sidiff.core.matching.hashing.d:
    org.sidiff.common.services.ServiceContext serviceContext -> b
    org.sidiff.core.correspondences.CorrespondencesService correspondencesService -> c
    org.sidiff.core.candidates.CandidatesService candidatesService -> d
    org.eclipse.emf.ecore.resource.Resource modelA -> e
    org.eclipse.emf.ecore.resource.Resource modelB -> f
    boolean $assertionsDisabled -> a
    void initialize(org.sidiff.common.services.ServiceContext,java.lang.Object[]) -> a
    void match() -> a
    java.util.List findHashMatches(org.sidiff.common.collections.ValueMap,org.sidiff.common.collections.ValueMap) -> a
    void analyze(java.util.List,org.sidiff.common.collections.ValueMap,org.sidiff.common.collections.ValueMap) -> a
    boolean checkCandidate(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject) -> a
    org.sidiff.core.correspondences.CorrespondencesService access$0(org.sidiff.core.matching.hashing.HashMatchingServiceImpl) -> a
org.sidiff.core.matching.hashing.HashMatchingServiceImpl$1 -> org.sidiff.core.matching.hashing.c:
    org.sidiff.core.matching.hashing.HashMatchingServiceImpl this$0 -> a
    boolean select(org.eclipse.emf.ecore.EObject) -> a
    boolean select(java.lang.Object) -> a
org.sidiff.core.matching.hashing.HashMatchingServiceImpl$2 -> org.sidiff.core.matching.hashing.b:
    org.sidiff.core.matching.hashing.HashMatchingServiceImpl this$0 -> a
    boolean select(org.eclipse.emf.ecore.EObject) -> a
    boolean select(java.lang.Object) -> a
org.sidiff.core.matching.hashing.HashMatchingServiceProviderImpl -> org.sidiff.core.matching.hashing.e:
    java.lang.Object createInstance() -> a
org.sidiff.core.matching.idbased.Activator -> org.sidiff.core.matching.idbased.a:
    void start(org.osgi.framework.BundleContext) -> start
    void stop(org.osgi.framework.BundleContext) -> stop
org.sidiff.core.matching.idbased.IDBasedMatchingServiceImpl -> org.sidiff.core.matching.idbased.b:
    org.sidiff.common.services.ServiceContext serviceContext -> b
    org.sidiff.core.correspondences.CorrespondencesService correspondencesService -> c
    org.sidiff.core.candidates.CandidatesService candidatesService -> d
    org.eclipse.emf.ecore.resource.Resource[] models -> e
    boolean $assertionsDisabled -> a
    void initialize(org.sidiff.common.services.ServiceContext,java.lang.Object[]) -> a
    void match() -> a
    boolean checkCandidate(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject) -> a
org.sidiff.core.matching.idbased.IDBasedMatchingServiceProviderImpl -> org.sidiff.core.matching.idbased.c:
    java.lang.Object createInstance() -> a
org.sidiff.core.matching.iterative.Activator -> org.sidiff.core.matching.iterative.b:
    void start(org.osgi.framework.BundleContext) -> start
    void stop(org.osgi.framework.BundleContext) -> stop
org.sidiff.core.matching.iterative.IterativeMatchingServiceImpl -> org.sidiff.core.matching.iterative.c:
    org.sidiff.core.matching.iterative.configuration.MatchingConfiguration configuration -> b
    org.sidiff.common.services.ServiceContext serviceContext -> c
    org.eclipse.emf.ecore.resource.Resource modelA -> d
    org.eclipse.emf.ecore.resource.Resource modelB -> e
    boolean newMatches -> f
    java.util.Map pending -> g
    java.util.Collection noMorePending -> h
    java.util.Set computedTypes -> i
    int round -> j
    org.sidiff.core.correspondences.CorrespondencesService correspondings -> k
    org.sidiff.core.compare.similarities.SimilaritiesService similarities -> l
    org.sidiff.core.compare.calculator.SimilaritiesCalculationService calculator -> m
    boolean $assertionsDisabled -> a
    void initialize(org.sidiff.common.services.ServiceContext,java.lang.Object[]) -> a
    void match() -> a
    int currentRound() -> c
    java.lang.Iterable getPendingObjects(org.eclipse.emf.ecore.EClass) -> b
    org.sidiff.common.services.ServiceContext getServiceContext() -> b
    java.util.SortedSet getSimilarities(org.eclipse.emf.ecore.EObject,boolean) -> a
    float getSimilarity(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject,boolean) -> a
    org.sidiff.core.matching.iterative.configuration.TypeConfiguration getTypeConfiguration(org.eclipse.emf.ecore.EClass) -> a
    boolean match(org.sidiff.core.matching.iterative.Matcher,org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject) -> a
    boolean isMatchPermitted(org.eclipse.emf.ecore.EObject) -> a
    void eventDispatched(org.sidiff.common.services.events.SCEvent) -> a
org.sidiff.core.matching.iterative.IterativeMatchingServiceProviderImpl -> org.sidiff.core.matching.iterative.a:
    org.sidiff.core.matching.iterative.configuration.ConfigurationHandler CONFIGHANDLER -> b
    org.sidiff.core.matching.iterative.configuration.MatchingConfiguration matchingConfiguration -> c
    java.lang.String configure(java.lang.Object[]) -> a
    void deconfigure() -> b
    java.util.Dictionary getProperties() -> c
    java.lang.Object createInstance() -> a
org.sidiff.core.matching.iterative.Matcher -> org.sidiff.core.matching.iterative.Matcher:
org.sidiff.core.matching.iterative.MatchingContext -> org.sidiff.core.matching.iterative.MatchingContext:
    org.sidiff.common.services.ServiceContext getServiceContext() -> b
    org.sidiff.core.matching.iterative.configuration.TypeConfiguration getTypeConfiguration(org.eclipse.emf.ecore.EClass) -> a
    java.lang.Iterable getPendingObjects(org.eclipse.emf.ecore.EClass) -> b
    java.util.SortedSet getSimilarities(org.eclipse.emf.ecore.EObject,boolean) -> a
    float getSimilarity(org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject,boolean) -> a
    boolean match(org.sidiff.core.matching.iterative.Matcher,org.eclipse.emf.ecore.EObject,org.eclipse.emf.ecore.EObject) -> a
    int currentRound() -> c
    boolean isMatchPermitted(org.eclipse.emf.ecore.EObject) -> a
org.sidiff.core.matching.iterative.SequencedMatcher -> org.sidiff.core.matching.iterative.SequencedMatcher:
    boolean performMatching(org.sidiff.core.matching.iterative.MatchingContext,org.sidiff.core.matching.iterative.configuration.Sequence) -> a
org.sidiff.core.matching.iterative.TopDownMatcher -> org.sidiff.core.matching.iterative.TopDownMatcher:
    boolean performMatching(org.sidiff.core.matching.iterative.MatchingContext,org.eclipse.emf.ecore.EObject[]) -> a
org.sidiff.core.matching.iterative.configuration.ConfigurationHandler -> org.sidiff.core.matching.iterative.configuration.ConfigurationHandler:
    org.sidiff.core.matching.iterative.configuration.MatchingConfiguration parseConfiguration(java.lang.Object) -> a
org.sidiff.core.matching.iterative.configuration.MatchingConfiguration -> org.sidiff.core.matching.iterative.configuration.f:
    org.eclipse.emf.ecore.EPackage ePackage -> b
    org.sidiff.core.matching.iterative.SequencedMatcher firstPassSequencedMatcher -> c
    org.sidiff.core.matching.iterative.SequencedMatcher defaultSequencedMatcher -> d
    boolean computeConfidence -> e
    org.sidiff.core.matching.iterative.configuration.Sequence matchingSequence -> f
    org.sidiff.common.emf.EMFMetaObjectExtender matchingConfigurations -> g
    boolean $assertionsDisabled -> a
    org.sidiff.core.matching.iterative.configuration.TypeConfiguration addTypeConfiguration(org.sidiff.core.matching.iterative.configuration.TypeConfiguration) -> a
    org.sidiff.core.matching.iterative.configuration.Sequence setMatchingSequence(org.sidiff.core.matching.iterative.configuration.Sequence) -> a
    org.sidiff.core.matching.iterative.configuration.TypeConfiguration getMatchingConfiguration(org.eclipse.emf.ecore.EClass) -> a
    org.sidiff.core.matching.iterative.configuration.Sequence getMatchingSequence() -> a
    org.eclipse.emf.ecore.EPackage getConfiguredEPackage() -> b
    org.sidiff.core.matching.iterative.SequencedMatcher getFirstPassSequencedMatcher() -> c
    org.sidiff.core.matching.iterative.SequencedMatcher getDefaultSequencedMatcher() -> d
    boolean isComputeConfidence() -> e
org.sidiff.core.matching.iterative.configuration.Sequence -> org.sidiff.core.matching.iterative.configuration.e:
    org.sidiff.core.matching.iterative.configuration.Sequence root -> a
    int level -> b
    java.util.List sequence -> c
    org.sidiff.core.matching.iterative.configuration.Sequence createSubSequence() -> b
    void addItem(org.sidiff.core.matching.iterative.configuration.SequenceItem) -> a
    boolean isSubSequence() -> c
    int getNestingLevel() -> d
    java.util.List getTypeList() -> e
    java.util.Iterator iterator() -> iterator
    java.lang.String toString() -> toString
    org.eclipse.emf.ecore.EClass getType() -> a
    java.lang.String toString(int) -> a
org.sidiff.core.matching.iterative.configuration.SequenceItem -> org.sidiff.core.matching.iterative.configuration.SequenceItem:
    org.eclipse.emf.ecore.EClass getType() -> a
org.sidiff.core.matching.iterative.configuration.SequenceTypeEntry -> org.sidiff.core.matching.iterative.configuration.c:
    org.eclipse.emf.ecore.EClass type -> b
    boolean $assertionsDisabled -> a
    org.eclipse.emf.ecore.EClass getType() -> a
    java.lang.String toString() -> toString
org.sidiff.core.matching.iterative.configuration.TypeConfiguration -> org.sidiff.core.matching.iterative.configuration.b:
    org.eclipse.emf.ecore.EClass type -> a
    float threshold -> b
    boolean allowLocalMove -> c
    boolean allowGlobalMove -> d
    boolean alwaysComputeSimilarity -> e
    boolean independentMatching -> f
    org.sidiff.core.matching.iterative.TopDownMatcher topDownMatcher -> g
    org.eclipse.emf.ecore.EClass getType() -> a
    float getThreshold() -> b
    boolean getAllowLocalMove() -> c
    boolean getAllowGlobalMove() -> d
    boolean getAlwaysComputeSimilarity() -> e
    boolean getIndependentMatching() -> f
    org.sidiff.core.matching.iterative.TopDownMatcher getTopDownMatcher() -> g
    java.lang.String toString() -> toString
org.sidiff.core.matching.iterative.configuration.XMLConfigurationHandler -> org.sidiff.core.matching.iterative.configuration.a:
    java.lang.String JAVA_NAMESPACE_SEPERATOR -> a
    java.lang.String ATT_SETTINGS_MATCHERPREFIX_CONST_DEFAULT -> b
    boolean ATT_SETTINGS_COMPUTECONFIDENCE_CONST_DEFAULT -> c
    boolean ATT_MATCHCONFIG_ALLOWLOCALMOVE_CONST_DEFAULT -> d
    java.lang.String ELEM_MATCHING -> e
    java.lang.String ELEM_SETTINGS -> f
    java.lang.String ATT_SETTINGS_MATCHERPREFIX -> g
    java.lang.String ATT_SETTINGS_DOCTYPE -> h
    java.lang.String ATT_SETTINGS_FIRSTPASSSEQMATCHER -> i
    java.lang.String ATT_SETTINGS_DEFSEQMATCHER -> j
    java.lang.String ATT_SETTINGS_DEFTOPDOWNMATCHER -> k
    java.lang.String ATT_SETTINGS_COMPUTECONFIDENCE -> l
    java.lang.String ELEM_CONFIGURATIONS -> m
    java.lang.String ELEM_MATCHINGCONFIG -> n
    java.lang.String ATT_MATCHCONFIG_CLASSNAME -> o
    java.lang.String ATT_MATCHCONFIG_THRESHOLD -> p
    java.lang.String ATT_MATCHCONFIG_ALLOWLOCALMOVE -> q
    java.lang.String ATT_MATCHCONFIG_ALLOWGLOBALMOVE -> r
    java.lang.String ATT_MATCHCONFIG_ALWAYSCOMPUTESIM -> s
    java.lang.String ATT_MATCHCONFIG_INDEPENDENTMATCHING -> t
    java.lang.String ATT_MATCHCONFIG_TOPDOWNMATCHER -> u
    java.lang.String ELEM_SEQUENCE -> v
    java.lang.String ELEM_CLASS -> w
    java.lang.String ATT_CLASS_NAME -> x
    org.eclipse.emf.ecore.EPackage ePackage -> y
    java.lang.String matcherPrefix -> z
    org.sidiff.core.matching.iterative.TopDownMatcher defaultTopDownMatcher -> A
    org.sidiff.core.matching.iterative.configuration.MatchingConfiguration processSettings(org.w3c.dom.Node) -> a
    org.sidiff.core.matching.iterative.configuration.MatchingConfiguration parseConfiguration(org.w3c.dom.Document) -> a
    org.sidiff.core.matching.iterative.configuration.TypeConfiguration createTypeConfiguration(org.eclipse.emf.ecore.EPackage,org.w3c.dom.Node) -> a
    org.sidiff.core.matching.iterative.configuration.Sequence parseSequence(org.w3c.dom.Node,org.sidiff.core.matching.iterative.configuration.Sequence) -> a
    java.lang.String getValue(org.w3c.dom.NamedNodeMap,java.lang.String) -> a
    java.lang.String getFullQualifiedName(java.lang.String,java.lang.String) -> a
    org.sidiff.core.matching.iterative.configuration.MatchingConfiguration parseConfiguration(java.lang.Object) -> a
    java.lang.String access$1(org.sidiff.core.matching.iterative.configuration.XMLConfigurationHandler,org.w3c.dom.NamedNodeMap,java.lang.String) -> a
org.sidiff.core.matching.iterative.configuration.XMLConfigurationHandler$InvalidArgumentException -> org.sidiff.core.matching.iterative.configuration.g:
    long serialVersionUID -> b
    org.sidiff.core.matching.iterative.configuration.XMLConfigurationHandler this$0 -> a
org.sidiff.core.matching.iterative.configuration.XMLConfigurationHandler$MissingPackageException -> org.sidiff.core.matching.iterative.configuration.d:
    long serialVersionUID -> b
    org.sidiff.core.matching.iterative.configuration.XMLConfigurationHandler this$0 -> a
org.sidiff.core.matching.matcher.AbstractMutualChildrenMatcher -> org.sidiff.core.matching.matcher.m:
    org.sidiff.common.collections.Selector SELECT_ALL -> c
    boolean $assertionsDisabled -> a
    boolean performMatching(org.sidiff.core.matching.iterative.MatchingContext,org.eclipse.emf.ecore.EReference,java.util.List,java.util.List) -> a
    org.eclipse.emf.ecore.EObject getIdealPartner(org.eclipse.emf.ecore.EObject,java.util.List,org.sidiff.core.matching.iterative.configuration.TypeConfiguration,org.sidiff.core.matching.iterative.MatchingContext,org.sidiff.common.collections.Selector) -> a
org.sidiff.core.matching.matcher.AbstractMutualChildrenMatcher$AcceptablePartnerSelector -> org.sidiff.core.matching.matcher.l:
    java.util.List partners -> b
    org.eclipse.emf.ecore.EObject partner -> c
    org.sidiff.core.matching.iterative.MatchingContext context -> d
    boolean $assertionsDisabled -> a
    boolean select(org.eclipse.emf.ecore.EObject) -> a
    boolean select(java.lang.Object) -> a
org.sidiff.core.matching.matcher.AbstractMutualPartnerMatcher -> org.sidiff.core.matching.matcher.g:
    org.sidiff.common.collections.Selector SELECT_ALL -> c
    boolean $assertionsDisabled -> b
    boolean performMatching(org.sidiff.core.matching.iterative.MatchingContext,java.lang.Iterable,org.sidiff.core.matching.iterative.configuration.TypeConfiguration) -> a
    org.sidiff.common.collections.Selector createAcceptablePartnerSelector(org.eclipse.emf.ecore.EObject,org.sidiff.core.matching.iterative.configuration.TypeConfiguration,org.sidiff.core.matching.iterative.MatchingContext) -> a
    org.eclipse.emf.ecore.EObject getIdealPartner(org.eclipse.emf.ecore.EObject,org.sidiff.core.matching.iterative.configuration.TypeConfiguration,org.sidiff.core.matching.iterative.MatchingContext,org.sidiff.common.collections.Selector) -> a
org.sidiff.core.matching.matcher.AbstractMutualPartnerMatcher$AcceptablePartnerSelector -> org.sidiff.core.matching.matcher.a:
    org.eclipse.emf.ecore.EObject neededParent -> b
    int neededIndex -> c
    boolean $assertionsDisabled -> a
    boolean select(org.eclipse.emf.ecore.EObject) -> a
    boolean select(java.lang.Object) -> a
org.sidiff.core.matching.matcher.AbstractParentForcedMatcher -> org.sidiff.core.matching.matcher.f:
    boolean $assertionsDisabled -> a
    boolean performMatching(org.sidiff.core.matching.iterative.MatchingContext,org.eclipse.emf.ecore.EReference,java.util.List,java.util.List) -> a
    org.eclipse.emf.ecore.EObject getIdealPartner(org.eclipse.emf.ecore.EObject,java.util.Collection,org.sidiff.core.matching.iterative.configuration.TypeConfiguration,org.sidiff.core.matching.iterative.MatchingContext) -> a
org.sidiff.core.matching.matcher.AbstractSequencedMatcher -> org.sidiff.core.matching.matcher.b:
    boolean $assertionsDisabled -> a
    boolean performMatching(org.sidiff.core.matching.iterative.MatchingContext,org.sidiff.core.matching.iterative.configuration.Sequence) -> a
    boolean performMatching(org.sidiff.core.matching.iterative.MatchingContext,java.lang.Iterable,org.sidiff.core.matching.iterative.configuration.TypeConfiguration) -> a
org.sidiff.core.matching.matcher.AbstractTopDownMatcher -> org.sidiff.core.matching.matcher.i:
    boolean $assertionsDisabled -> b
    boolean performMatching(org.sidiff.core.matching.iterative.MatchingContext,org.eclipse.emf.ecore.EObject[]) -> a
    boolean performMatching(org.sidiff.core.matching.iterative.MatchingContext,org.eclipse.emf.ecore.EReference,java.util.List,java.util.List) -> a
org.sidiff.core.matching.matcher.DefaultMatcher -> org.sidiff.core.matching.matcher.k:
    org.eclipse.emf.ecore.EObject getIdealPartner(org.eclipse.emf.ecore.EObject,org.sidiff.core.matching.iterative.configuration.TypeConfiguration,org.sidiff.core.matching.iterative.MatchingContext,org.sidiff.common.collections.Selector) -> a
org.sidiff.core.matching.matcher.GreedyParentForcedMatcher -> org.sidiff.core.matching.matcher.j:
    org.eclipse.emf.ecore.EObject getIdealPartner(org.eclipse.emf.ecore.EObject,java.util.Collection,org.sidiff.core.matching.iterative.configuration.TypeConfiguration,org.sidiff.core.matching.iterative.MatchingContext) -> a
org.sidiff.core.matching.matcher.NoPropagation -> org.sidiff.core.matching.matcher.h:
    boolean $assertionsDisabled -> a
    boolean performMatching(org.sidiff.core.matching.iterative.MatchingContext,org.eclipse.emf.ecore.EObject[]) -> a
org.sidiff.core.matching.matcher.Propagation -> org.sidiff.core.matching.matcher.e:
    org.eclipse.emf.ecore.EObject getIdealPartner(org.eclipse.emf.ecore.EObject,java.util.List,org.sidiff.core.matching.iterative.configuration.TypeConfiguration,org.sidiff.core.matching.iterative.MatchingContext,org.sidiff.common.collections.Selector) -> a
org.sidiff.core.matching.matcher.UniquePropagation -> org.sidiff.core.matching.matcher.c:
    org.eclipse.emf.ecore.EObject getIdealPartner(org.eclipse.emf.ecore.EObject,java.util.List,org.sidiff.core.matching.iterative.configuration.TypeConfiguration,org.sidiff.core.matching.iterative.MatchingContext,org.sidiff.common.collections.Selector) -> a
org.sidiff.core.matching.matcher.UniqueSimilarityMatcher -> org.sidiff.core.matching.matcher.d:
    org.eclipse.emf.ecore.EObject getIdealPartner(org.eclipse.emf.ecore.EObject,org.sidiff.core.matching.iterative.configuration.TypeConfiguration,org.sidiff.core.matching.iterative.MatchingContext,org.sidiff.common.collections.Selector) -> a
org.sidiff.uml.diff.Activator -> org.sidiff.uml.diff.c:
    java.lang.String DOCUMENT_TYPE -> a
    org.osgi.framework.BundleContext bundleContext -> b
    void start(org.osgi.framework.BundleContext) -> start
    void stop(org.osgi.framework.BundleContext) -> stop
    org.osgi.framework.BundleContext getBundleContext() -> a
    void configureServices() -> b
org.sidiff.uml.diff.UMLCompareInterface -> org.sidiff.uml.diff.b:
    org.sidiff.uml.diff.UMLCompareInterface$UMLCompareType type -> b
    boolean $assertionsDisabled -> a
    int[] $SWITCH_TABLE$org$sidiff$uml$diff$UMLCompareInterface$UMLCompareType -> c
    java.lang.String getDescription() -> d
    java.lang.String getDocumentType() -> c
    void createContext(java.lang.Object[]) -> a
    void compare(java.lang.Object[]) -> b
    int[] $SWITCH_TABLE$org$sidiff$uml$diff$UMLCompareInterface$UMLCompareType() -> e
org.sidiff.uml.diff.UMLCompareInterface$UMLCompareType -> org.sidiff.uml.diff.d:
    org.sidiff.uml.diff.UMLCompareInterface$UMLCompareType IDBASED -> a
    org.sidiff.uml.diff.UMLCompareInterface$UMLCompareType ITERATIVE -> b
    org.sidiff.uml.diff.UMLCompareInterface$UMLCompareType ITERATIVE_NOHASH -> c
    org.sidiff.uml.diff.UMLCompareInterface$UMLCompareType[] ENUM$VALUES -> d
    org.sidiff.uml.diff.UMLCompareInterface$UMLCompareType[] values() -> values
    org.sidiff.uml.diff.UMLCompareInterface$UMLCompareType valueOf(java.lang.String) -> valueOf
org.sidiff.uml.diff.UmlDiff -> org.sidiff.uml.diff.a:
    org.sidiff.common.app.CommandLine$Argument fileP1 -> a
    org.sidiff.common.app.CommandLine$Argument fileP2 -> b
    org.sidiff.common.app.CommandLine$Argument nohash -> c
    org.sidiff.common.app.CommandLine$Argument idbased -> d
    org.sidiff.common.app.CommandLine$Argument outfile -> e
    java.lang.Object start(org.eclipse.equinox.app.IApplicationContext) -> start
    void stop() -> stop
org.sidiff.uml.metrics.Activator -> org.sidiff.uml.metrics.b:
    void start(org.osgi.framework.BundleContext) -> start
    void stop(org.osgi.framework.BundleContext) -> stop
org.sidiff.uml.metrics.CalculateAttributeDeclaration -> org.sidiff.uml.metrics.k:
    java.lang.Object computeAnnotationValue(org.eclipse.emf.ecore.EObject) -> e
org.sidiff.uml.metrics.CalculateInheritance -> org.sidiff.uml.metrics.d:
    java.lang.String ATTRS -> a
    java.lang.String OPS -> b
    java.lang.String IATTRS -> c
    java.lang.String IOPS -> d
    java.lang.String WNOC -> e
    java.lang.String DIT -> f
    java.lang.String ADECL -> g
    java.lang.String MDECL -> h
    java.lang.String NOC -> i
    java.lang.String SUP -> j
    java.lang.Object computeAnnotationValue(org.eclipse.emf.ecore.EObject) -> e
    java.lang.Float calculateInheritanceRecursively(org.eclipse.emf.ecore.EObject,java.lang.Float,java.util.ArrayList,java.util.ArrayList) -> a
    java.util.ArrayList getOperationDeclarations(org.eclipse.emf.ecore.EObject) -> f
    java.util.ArrayList getAttributeDeclarations(org.eclipse.emf.ecore.EObject) -> h
org.sidiff.uml.metrics.CalculateMethodDeclaration -> org.sidiff.uml.metrics.f:
    java.lang.Object computeAnnotationValue(org.eclipse.emf.ecore.EObject) -> e
org.sidiff.uml.metrics.CountAttributesInherited -> org.sidiff.uml.metrics.c:
    java.lang.Object computeAnnotationValue(org.eclipse.emf.ecore.EObject) -> e
org.sidiff.uml.metrics.CountClassConstructors -> org.sidiff.uml.metrics.g:
    java.lang.Object computeAnnotationValue(org.eclipse.emf.ecore.EObject) -> e
org.sidiff.uml.metrics.CountMethodDeclarationLength -> org.sidiff.uml.metrics.m:
    java.lang.Object computeAnnotationValue(org.eclipse.emf.ecore.EObject) -> e
org.sidiff.uml.metrics.CountMethodOverloadFrequency -> org.sidiff.uml.metrics.j:
    java.lang.Object computeAnnotationValue(org.eclipse.emf.ecore.EObject) -> e
org.sidiff.uml.metrics.CountMethodsAdded -> org.sidiff.uml.metrics.e:
    java.lang.Object computeAnnotationValue(org.eclipse.emf.ecore.EObject) -> e
org.sidiff.uml.metrics.CountMethodsInherited -> org.sidiff.uml.metrics.i:
    java.lang.Object computeAnnotationValue(org.eclipse.emf.ecore.EObject) -> e
org.sidiff.uml.metrics.CountMethodsOverloaded -> org.sidiff.uml.metrics.l:
    java.lang.Object computeAnnotationValue(org.eclipse.emf.ecore.EObject) -> e
org.sidiff.uml.metrics.CountMethodsOverloadedInheritance -> org.sidiff.uml.metrics.a:
    java.lang.Object computeAnnotationValue(org.eclipse.emf.ecore.EObject) -> e
org.sidiff.uml.metrics.CountMethodsOverridden -> org.sidiff.uml.metrics.h:
    java.lang.Object computeAnnotationValue(org.eclipse.emf.ecore.EObject) -> e
org.sidiff.uml.model.Activator -> org.sidiff.uml.model.Activator:
    java.util.Map URIMAP -> URIMAP
    org.sidiff.common.emf.modelstorage.Loader rationalEMXLoader -> rationalEMXLoader
    org.sidiff.common.emf.modelstorage.Loader fujabaXMILoader -> fujabaXMILoader
    void start(org.osgi.framework.BundleContext) -> start
    void stop(org.osgi.framework.BundleContext) -> stop
    java.util.Map access$0() -> access$0
org.sidiff.uml.model.Activator$1 -> org.sidiff.uml.model.Activator$1:
    org.sidiff.uml.model.Activator this$0 -> this$0
    java.lang.String getSuffix() -> getSuffix
    java.util.Set getMagicKeys() -> getMagicKeys
    java.lang.String getXSLTName() -> getXSLTName
    java.lang.String getXSLTDescription() -> getXSLTDescription
    java.util.Map getSchemaLocationMappings() -> getSchemaLocationMappings
org.sidiff.uml.model.Activator$2 -> org.sidiff.uml.model.Activator$2:
    org.sidiff.uml.model.Activator this$0 -> this$0
    java.lang.String getSuffix() -> getSuffix
    java.util.Set getMagicKeys() -> getMagicKeys
    java.lang.String getXSLTName() -> getXSLTName
    java.lang.String getXSLTDescription() -> getXSLTDescription
    java.util.Map getSchemaLocationMappings() -> getSchemaLocationMappings
org.sidiff.uml.model.Dummy -> org.sidiff.uml.model.Dummy:
org.sidiff.uml.model.ModelFactory -> org.sidiff.uml.model.ModelFactory:
    org.sidiff.uml.model.ModelFactory eINSTANCE -> eINSTANCE
    org.sidiff.uml.model.ModelPackage getModelPackage() -> getModelPackage
org.sidiff.uml.model.ModelPackage -> org.sidiff.uml.model.ModelPackage:
    java.lang.String eNAME -> eNAME
    java.lang.String eNS_URI -> eNS_URI
    java.lang.String eNS_PREFIX -> eNS_PREFIX
    org.sidiff.uml.model.ModelPackage eINSTANCE -> eINSTANCE
    int DUMMY -> DUMMY
    int DUMMY_FEATURE_COUNT -> DUMMY_FEATURE_COUNT
    org.eclipse.emf.ecore.EClass getDummy() -> getDummy
    org.sidiff.uml.model.ModelFactory getModelFactory() -> getModelFactory
org.sidiff.uml.model.ModelPackage$Literals -> org.sidiff.uml.model.ModelPackage$Literals:
    org.eclipse.emf.ecore.EClass DUMMY -> DUMMY
org.sidiff.uml.model.classes.ClassesFactory -> org.sidiff.uml.model.classes.ClassesFactory:
    org.sidiff.uml.model.classes.ClassesFactory eINSTANCE -> eINSTANCE
    org.sidiff.uml.model.classes.UMLAssociation createUMLAssociation() -> createUMLAssociation
    org.sidiff.uml.model.classes.UMLGeneralization createUMLGeneralization() -> createUMLGeneralization
    org.sidiff.uml.model.classes.UMLTemplateBinding createUMLTemplateBinding() -> createUMLTemplateBinding
    org.sidiff.uml.model.classes.UMLTemplateParameter createUMLTemplateParameter() -> createUMLTemplateParameter
    org.sidiff.uml.model.classes.UMLAssociationEnd createUMLAssociationEnd() -> createUMLAssociationEnd
    org.sidiff.uml.model.classes.UMLEnumeration createUMLEnumeration() -> createUMLEnumeration
    org.sidiff.uml.model.classes.UMLLiteral createUMLLiteral() -> createUMLLiteral
    org.sidiff.uml.model.classes.UMLPrimitiveType createUMLPrimitiveType() -> createUMLPrimitiveType
    org.sidiff.uml.model.classes.UMLAssociationClass createUMLAssociationClass() -> createUMLAssociationClass
    org.sidiff.uml.model.classes.UMLClass createUMLClass() -> createUMLClass
    org.sidiff.uml.model.classes.UMLOperation createUMLOperation() -> createUMLOperation
    org.sidiff.uml.model.classes.UMLInterface createUMLInterface() -> createUMLInterface
    org.sidiff.uml.model.classes.UMLParameter createUMLParameter() -> createUMLParameter
    org.sidiff.uml.model.classes.UMLAttribute createUMLAttribute() -> createUMLAttribute
    org.sidiff.uml.model.classes.ClassesPackage getClassesPackage() -> getClassesPackage
org.sidiff.uml.model.classes.ClassesPackage -> org.sidiff.uml.model.classes.ClassesPackage:
    java.lang.String eNAME -> eNAME
    java.lang.String eNS_URI -> eNS_URI
    java.lang.String eNS_PREFIX -> eNS_PREFIX
    org.sidiff.uml.model.classes.ClassesPackage eINSTANCE -> eINSTANCE
    int UML_ASSOCIATION -> UML_ASSOCIATION
    int UML_ASSOCIATION__ID -> UML_ASSOCIATION__ID
    int UML_ASSOCIATION__COMMENTS -> UML_ASSOCIATION__COMMENTS
    int UML_ASSOCIATION__OUTGOING_DEPENDENCIES -> UML_ASSOCIATION__OUTGOING_DEPENDENCIES
    int UML_ASSOCIATION__DEPENDEES -> UML_ASSOCIATION__DEPENDEES
    int UML_ASSOCIATION__NAME -> UML_ASSOCIATION__NAME
    int UML_ASSOCIATION__SPECIALIZATIONS -> UML_ASSOCIATION__SPECIALIZATIONS
    int UML_ASSOCIATION__GENERALIZATIONS -> UML_ASSOCIATION__GENERALIZATIONS
    int UML_ASSOCIATION__STEREOTYPES -> UML_ASSOCIATION__STEREOTYPES
    int UML_ASSOCIATION__ASSOCIATION_ENDS -> UML_ASSOCIATION__ASSOCIATION_ENDS
    int UML_ASSOCIATION__PACKAGE -> UML_ASSOCIATION__PACKAGE
    int UML_ASSOCIATION_FEATURE_COUNT -> UML_ASSOCIATION_FEATURE_COUNT
    int UML_TYPE -> UML_TYPE
    int UML_TYPE__ID -> UML_TYPE__ID
    int UML_TYPE__COMMENTS -> UML_TYPE__COMMENTS
    int UML_TYPE__OUTGOING_DEPENDENCIES -> UML_TYPE__OUTGOING_DEPENDENCIES
    int UML_TYPE__DEPENDEES -> UML_TYPE__DEPENDEES
    int UML_TYPE__NAME -> UML_TYPE__NAME
    int UML_TYPE__USED_BY_ELEMENTS -> UML_TYPE__USED_BY_ELEMENTS
    int UML_TYPE_FEATURE_COUNT -> UML_TYPE_FEATURE_COUNT
    int UML_CLASSIFIER -> UML_CLASSIFIER
    int UML_CLASSIFIER__ID -> UML_CLASSIFIER__ID
    int UML_CLASSIFIER__COMMENTS -> UML_CLASSIFIER__COMMENTS
    int UML_CLASSIFIER__OUTGOING_DEPENDENCIES -> UML_CLASSIFIER__OUTGOING_DEPENDENCIES
    int UML_CLASSIFIER__DEPENDEES -> UML_CLASSIFIER__DEPENDEES
    int UML_CLASSIFIER__NAME -> UML_CLASSIFIER__NAME
    int UML_CLASSIFIER__USED_BY_ELEMENTS -> UML_CLASSIFIER__USED_BY_ELEMENTS
    int UML_CLASSIFIER__SPECIALIZATIONS -> UML_CLASSIFIER__SPECIALIZATIONS
    int UML_CLASSIFIER__GENERALIZATIONS -> UML_CLASSIFIER__GENERALIZATIONS
    int UML_CLASSIFIER__TEMPLATE_BINDINGS -> UML_CLASSIFIER__TEMPLATE_BINDINGS
    int UML_CLASSIFIER__STEREOTYPES -> UML_CLASSIFIER__STEREOTYPES
    int UML_CLASSIFIER__TEMPLATE_PARAMETERS -> UML_CLASSIFIER__TEMPLATE_PARAMETERS
    int UML_CLASSIFIER__VISIBILITY -> UML_CLASSIFIER__VISIBILITY
    int UML_CLASSIFIER__TARGETED_BY_ASSOCIATION_ENDS -> UML_CLASSIFIER__TARGETED_BY_ASSOCIATION_ENDS
    int UML_CLASSIFIER__PACKAGE -> UML_CLASSIFIER__PACKAGE
    int UML_CLASSIFIER_FEATURE_COUNT -> UML_CLASSIFIER_FEATURE_COUNT
    int UML_TYPED_ELEMENT -> UML_TYPED_ELEMENT
    int UML_TYPED_ELEMENT__TYPE -> UML_TYPED_ELEMENT__TYPE
    int UML_TYPED_ELEMENT_FEATURE_COUNT -> UML_TYPED_ELEMENT_FEATURE_COUNT
    int UML_GENERALIZABLE_ELEMENT -> UML_GENERALIZABLE_ELEMENT
    int UML_GENERALIZABLE_ELEMENT__SPECIALIZATIONS -> UML_GENERALIZABLE_ELEMENT__SPECIALIZATIONS
    int UML_GENERALIZABLE_ELEMENT__GENERALIZATIONS -> UML_GENERALIZABLE_ELEMENT__GENERALIZATIONS
    int UML_GENERALIZABLE_ELEMENT_FEATURE_COUNT -> UML_GENERALIZABLE_ELEMENT_FEATURE_COUNT
    int UML_GENERALIZATION -> UML_GENERALIZATION
    int UML_GENERALIZATION__ID -> UML_GENERALIZATION__ID
    int UML_GENERALIZATION__COMMENTS -> UML_GENERALIZATION__COMMENTS
    int UML_GENERALIZATION__SPECIAL_ELEMENT -> UML_GENERALIZATION__SPECIAL_ELEMENT
    int UML_GENERALIZATION__GENERAL_ELEMENT -> UML_GENERALIZATION__GENERAL_ELEMENT
    int UML_GENERALIZATION_FEATURE_COUNT -> UML_GENERALIZATION_FEATURE_COUNT
    int UML_BINDING_ELEMENT -> UML_BINDING_ELEMENT
    int UML_BINDING_ELEMENT__TEMPLATE_BINDINGS -> UML_BINDING_ELEMENT__TEMPLATE_BINDINGS
    int UML_BINDING_ELEMENT_FEATURE_COUNT -> UML_BINDING_ELEMENT_FEATURE_COUNT
    int UML_TEMPLATE_BINDING -> UML_TEMPLATE_BINDING
    int UML_TEMPLATE_BINDING__ID -> UML_TEMPLATE_BINDING__ID
    int UML_TEMPLATE_BINDING__COMMENTS -> UML_TEMPLATE_BINDING__COMMENTS
    int UML_TEMPLATE_BINDING__FORMAL_PARAM -> UML_TEMPLATE_BINDING__FORMAL_PARAM
    int UML_TEMPLATE_BINDING__ACTUAL_PARAM -> UML_TEMPLATE_BINDING__ACTUAL_PARAM
    int UML_TEMPLATE_BINDING__BINDER -> UML_TEMPLATE_BINDING__BINDER
    int UML_TEMPLATE_BINDING_FEATURE_COUNT -> UML_TEMPLATE_BINDING_FEATURE_COUNT
    int UML_TEMPLATE_PARAMETER -> UML_TEMPLATE_PARAMETER
    int UML_TEMPLATE_PARAMETER__ID -> UML_TEMPLATE_PARAMETER__ID
    int UML_TEMPLATE_PARAMETER__COMMENTS -> UML_TEMPLATE_PARAMETER__COMMENTS
    int UML_TEMPLATE_PARAMETER__TEMPLATEABLE_ELEMENT -> UML_TEMPLATE_PARAMETER__TEMPLATEABLE_ELEMENT
    int UML_TEMPLATE_PARAMETER__TYPE -> UML_TEMPLATE_PARAMETER__TYPE
    int UML_TEMPLATE_PARAMETER__BINDINGS -> UML_TEMPLATE_PARAMETER__BINDINGS
    int UML_TEMPLATE_PARAMETER_FEATURE_COUNT -> UML_TEMPLATE_PARAMETER_FEATURE_COUNT
    int UML_TEMPLATEABLE_ELEMENT -> UML_TEMPLATEABLE_ELEMENT
    int UML_TEMPLATEABLE_ELEMENT__TEMPLATE_PARAMETERS -> UML_TEMPLATEABLE_ELEMENT__TEMPLATE_PARAMETERS
    int UML_TEMPLATEABLE_ELEMENT_FEATURE_COUNT -> UML_TEMPLATEABLE_ELEMENT_FEATURE_COUNT
    int UML_ASSOCIATION_END -> UML_ASSOCIATION_END
    int UML_ASSOCIATION_END__ID -> UML_ASSOCIATION_END__ID
    int UML_ASSOCIATION_END__COMMENTS -> UML_ASSOCIATION_END__COMMENTS
    int UML_ASSOCIATION_END__OUTGOING_DEPENDENCIES -> UML_ASSOCIATION_END__OUTGOING_DEPENDENCIES
    int UML_ASSOCIATION_END__DEPENDEES -> UML_ASSOCIATION_END__DEPENDEES
    int UML_ASSOCIATION_END__NAME -> UML_ASSOCIATION_END__NAME
    int UML_ASSOCIATION_END__STEREOTYPES -> UML_ASSOCIATION_END__STEREOTYPES
    int UML_ASSOCIATION_END__ASSOCIATION -> UML_ASSOCIATION_END__ASSOCIATION
    int UML_ASSOCIATION_END__MULTIPLICITY -> UML_ASSOCIATION_END__MULTIPLICITY
    int UML_ASSOCIATION_END__IS_NAVIGABLE -> UML_ASSOCIATION_END__IS_NAVIGABLE
    int UML_ASSOCIATION_END__KIND -> UML_ASSOCIATION_END__KIND
    int UML_ASSOCIATION_END__IS_ORDERED -> UML_ASSOCIATION_END__IS_ORDERED
    int UML_ASSOCIATION_END__TARGET -> UML_ASSOCIATION_END__TARGET
    int UML_ASSOCIATION_END_FEATURE_COUNT -> UML_ASSOCIATION_END_FEATURE_COUNT
    int UML_ENUMERATION -> UML_ENUMERATION
    int UML_ENUMERATION__ID -> UML_ENUMERATION__ID
    int UML_ENUMERATION__COMMENTS -> UML_ENUMERATION__COMMENTS
    int UML_ENUMERATION__OUTGOING_DEPENDENCIES -> UML_ENUMERATION__OUTGOING_DEPENDENCIES
    int UML_ENUMERATION__DEPENDEES -> UML_ENUMERATION__DEPENDEES
    int UML_ENUMERATION__NAME -> UML_ENUMERATION__NAME
    int UML_ENUMERATION__USED_BY_ELEMENTS -> UML_ENUMERATION__USED_BY_ELEMENTS
    int UML_ENUMERATION__VISIBILITY -> UML_ENUMERATION__VISIBILITY
    int UML_ENUMERATION__LITERALS -> UML_ENUMERATION__LITERALS
    int UML_ENUMERATION__PACKAGE -> UML_ENUMERATION__PACKAGE
    int UML_ENUMERATION_FEATURE_COUNT -> UML_ENUMERATION_FEATURE_COUNT
    int UML_LITERAL -> UML_LITERAL
    int UML_LITERAL__ID -> UML_LITERAL__ID
    int UML_LITERAL__COMMENTS -> UML_LITERAL__COMMENTS
    int UML_LITERAL__OUTGOING_DEPENDENCIES -> UML_LITERAL__OUTGOING_DEPENDENCIES
    int UML_LITERAL__DEPENDEES -> UML_LITERAL__DEPENDEES
    int UML_LITERAL__NAME -> UML_LITERAL__NAME
    int UML_LITERAL__ENUMERATION -> UML_LITERAL__ENUMERATION
    int UML_LITERAL_FEATURE_COUNT -> UML_LITERAL_FEATURE_COUNT
    int UML_PRIMITIVE_TYPE -> UML_PRIMITIVE_TYPE
    int UML_PRIMITIVE_TYPE__ID -> UML_PRIMITIVE_TYPE__ID
    int UML_PRIMITIVE_TYPE__COMMENTS -> UML_PRIMITIVE_TYPE__COMMENTS
    int UML_PRIMITIVE_TYPE__OUTGOING_DEPENDENCIES -> UML_PRIMITIVE_TYPE__OUTGOING_DEPENDENCIES
    int UML_PRIMITIVE_TYPE__DEPENDEES -> UML_PRIMITIVE_TYPE__DEPENDEES
    int UML_PRIMITIVE_TYPE__NAME -> UML_PRIMITIVE_TYPE__NAME
    int UML_PRIMITIVE_TYPE__USED_BY_ELEMENTS -> UML_PRIMITIVE_TYPE__USED_BY_ELEMENTS
    int UML_PRIMITIVE_TYPE__PACKAGE -> UML_PRIMITIVE_TYPE__PACKAGE
    int UML_PRIMITIVE_TYPE_FEATURE_COUNT -> UML_PRIMITIVE_TYPE_FEATURE_COUNT
    int UML_ASSOCIATION_CLASS -> UML_ASSOCIATION_CLASS
    int UML_ASSOCIATION_CLASS__ID -> UML_ASSOCIATION_CLASS__ID
    int UML_ASSOCIATION_CLASS__COMMENTS -> UML_ASSOCIATION_CLASS__COMMENTS
    int UML_ASSOCIATION_CLASS__OUTGOING_DEPENDENCIES -> UML_ASSOCIATION_CLASS__OUTGOING_DEPENDENCIES
    int UML_ASSOCIATION_CLASS__DEPENDEES -> UML_ASSOCIATION_CLASS__DEPENDEES
    int UML_ASSOCIATION_CLASS__NAME -> UML_ASSOCIATION_CLASS__NAME
    int UML_ASSOCIATION_CLASS__SPECIALIZATIONS -> UML_ASSOCIATION_CLASS__SPECIALIZATIONS
    int UML_ASSOCIATION_CLASS__GENERALIZATIONS -> UML_ASSOCIATION_CLASS__GENERALIZATIONS
    int UML_ASSOCIATION_CLASS__STEREOTYPES -> UML_ASSOCIATION_CLASS__STEREOTYPES
    int UML_ASSOCIATION_CLASS__ASSOCIATION_ENDS -> UML_ASSOCIATION_CLASS__ASSOCIATION_ENDS
    int UML_ASSOCIATION_CLASS__PACKAGE -> UML_ASSOCIATION_CLASS__PACKAGE
    int UML_ASSOCIATION_CLASS_FEATURE_COUNT -> UML_ASSOCIATION_CLASS_FEATURE_COUNT
    int UML_CLASS -> UML_CLASS
    int UML_CLASS__ID -> UML_CLASS__ID
    int UML_CLASS__COMMENTS -> UML_CLASS__COMMENTS
    int UML_CLASS__OUTGOING_DEPENDENCIES -> UML_CLASS__OUTGOING_DEPENDENCIES
    int UML_CLASS__DEPENDEES -> UML_CLASS__DEPENDEES
    int UML_CLASS__NAME -> UML_CLASS__NAME
    int UML_CLASS__USED_BY_ELEMENTS -> UML_CLASS__USED_BY_ELEMENTS
    int UML_CLASS__SPECIALIZATIONS -> UML_CLASS__SPECIALIZATIONS
    int UML_CLASS__GENERALIZATIONS -> UML_CLASS__GENERALIZATIONS
    int UML_CLASS__TEMPLATE_BINDINGS -> UML_CLASS__TEMPLATE_BINDINGS
    int UML_CLASS__STEREOTYPES -> UML_CLASS__STEREOTYPES
    int UML_CLASS__TEMPLATE_PARAMETERS -> UML_CLASS__TEMPLATE_PARAMETERS
    int UML_CLASS__VISIBILITY -> UML_CLASS__VISIBILITY
    int UML_CLASS__TARGETED_BY_ASSOCIATION_ENDS -> UML_CLASS__TARGETED_BY_ASSOCIATION_ENDS
    int UML_CLASS__PACKAGE -> UML_CLASS__PACKAGE
    int UML_CLASS__IS_ABSTRACT -> UML_CLASS__IS_ABSTRACT
    int UML_CLASS__IS_FINAL -> UML_CLASS__IS_FINAL
    int UML_CLASS__OPERATIONS -> UML_CLASS__OPERATIONS
    int UML_CLASS__ATTRIBUTES -> UML_CLASS__ATTRIBUTES
    int UML_CLASS_FEATURE_COUNT -> UML_CLASS_FEATURE_COUNT
    int UML_OPERATION -> UML_OPERATION
    int UML_OPERATION__ID -> UML_OPERATION__ID
    int UML_OPERATION__COMMENTS -> UML_OPERATION__COMMENTS
    int UML_OPERATION__OUTGOING_DEPENDENCIES -> UML_OPERATION__OUTGOING_DEPENDENCIES
    int UML_OPERATION__DEPENDEES -> UML_OPERATION__DEPENDEES
    int UML_OPERATION__NAME -> UML_OPERATION__NAME
    int UML_OPERATION__STEREOTYPES -> UML_OPERATION__STEREOTYPES
    int UML_OPERATION__TYPE -> UML_OPERATION__TYPE
    int UML_OPERATION__VISIBILITY -> UML_OPERATION__VISIBILITY
    int UML_OPERATION__IS_ABSTRACT -> UML_OPERATION__IS_ABSTRACT
    int UML_OPERATION__IS_STATIC -> UML_OPERATION__IS_STATIC
    int UML_OPERATION__INTERFACE -> UML_OPERATION__INTERFACE
    int UML_OPERATION__PARAMETERS -> UML_OPERATION__PARAMETERS
    int UML_OPERATION__CLASS -> UML_OPERATION__CLASS
    int UML_OPERATION_FEATURE_COUNT -> UML_OPERATION_FEATURE_COUNT
    int UML_INTERFACE -> UML_INTERFACE
    int UML_INTERFACE__ID -> UML_INTERFACE__ID
    int UML_INTERFACE__COMMENTS -> UML_INTERFACE__COMMENTS
    int UML_INTERFACE__OUTGOING_DEPENDENCIES -> UML_INTERFACE__OUTGOING_DEPENDENCIES
    int UML_INTERFACE__DEPENDEES -> UML_INTERFACE__DEPENDEES
    int UML_INTERFACE__NAME -> UML_INTERFACE__NAME
    int UML_INTERFACE__USED_BY_ELEMENTS -> UML_INTERFACE__USED_BY_ELEMENTS
    int UML_INTERFACE__SPECIALIZATIONS -> UML_INTERFACE__SPECIALIZATIONS
    int UML_INTERFACE__GENERALIZATIONS -> UML_INTERFACE__GENERALIZATIONS
    int UML_INTERFACE__TEMPLATE_BINDINGS -> UML_INTERFACE__TEMPLATE_BINDINGS
    int UML_INTERFACE__STEREOTYPES -> UML_INTERFACE__STEREOTYPES
    int UML_INTERFACE__TEMPLATE_PARAMETERS -> UML_INTERFACE__TEMPLATE_PARAMETERS
    int UML_INTERFACE__VISIBILITY -> UML_INTERFACE__VISIBILITY
    int UML_INTERFACE__TARGETED_BY_ASSOCIATION_ENDS -> UML_INTERFACE__TARGETED_BY_ASSOCIATION_ENDS
    int UML_INTERFACE__PACKAGE -> UML_INTERFACE__PACKAGE
    int UML_INTERFACE__OPERATIONS -> UML_INTERFACE__OPERATIONS
    int UML_INTERFACE_FEATURE_COUNT -> UML_INTERFACE_FEATURE_COUNT
    int UML_PARAMETER -> UML_PARAMETER
    int UML_PARAMETER__ID -> UML_PARAMETER__ID
    int UML_PARAMETER__COMMENTS -> UML_PARAMETER__COMMENTS
    int UML_PARAMETER__OUTGOING_DEPENDENCIES -> UML_PARAMETER__OUTGOING_DEPENDENCIES
    int UML_PARAMETER__DEPENDEES -> UML_PARAMETER__DEPENDEES
    int UML_PARAMETER__NAME -> UML_PARAMETER__NAME
    int UML_PARAMETER__STEREOTYPES -> UML_PARAMETER__STEREOTYPES
    int UML_PARAMETER__TYPE -> UML_PARAMETER__TYPE
    int UML_PARAMETER__KIND -> UML_PARAMETER__KIND
    int UML_PARAMETER__OPERATION -> UML_PARAMETER__OPERATION
    int UML_PARAMETER_FEATURE_COUNT -> UML_PARAMETER_FEATURE_COUNT
    int UML_ATTRIBUTE -> UML_ATTRIBUTE
    int UML_ATTRIBUTE__ID -> UML_ATTRIBUTE__ID
    int UML_ATTRIBUTE__COMMENTS -> UML_ATTRIBUTE__COMMENTS
    int UML_ATTRIBUTE__OUTGOING_DEPENDENCIES -> UML_ATTRIBUTE__OUTGOING_DEPENDENCIES
    int UML_ATTRIBUTE__DEPENDEES -> UML_ATTRIBUTE__DEPENDEES
    int UML_ATTRIBUTE__NAME -> UML_ATTRIBUTE__NAME
    int UML_ATTRIBUTE__STEREOTYPES -> UML_ATTRIBUTE__STEREOTYPES
    int UML_ATTRIBUTE__TYPE -> UML_ATTRIBUTE__TYPE
    int UML_ATTRIBUTE__VISIBILITY -> UML_ATTRIBUTE__VISIBILITY
    int UML_ATTRIBUTE__IS_STATIC -> UML_ATTRIBUTE__IS_STATIC
    int UML_ATTRIBUTE__IS_FINAL -> UML_ATTRIBUTE__IS_FINAL
    int UML_ATTRIBUTE__IS_READ_ONLY -> UML_ATTRIBUTE__IS_READ_ONLY
    int UML_ATTRIBUTE__CLASS -> UML_ATTRIBUTE__CLASS
    int UML_ATTRIBUTE_FEATURE_COUNT -> UML_ATTRIBUTE_FEATURE_COUNT
    int UML_AGGREGATION_KIND -> UML_AGGREGATION_KIND
    int UML_PARAMETER_KIND -> UML_PARAMETER_KIND
    org.eclipse.emf.ecore.EClass getUMLAssociation() -> getUMLAssociation
    org.eclipse.emf.ecore.EReference getUMLAssociation_AssociationEnds() -> getUMLAssociation_AssociationEnds
    org.eclipse.emf.ecore.EReference getUMLAssociation_Package() -> getUMLAssociation_Package
    org.eclipse.emf.ecore.EClass getUMLClassifier() -> getUMLClassifier
    org.eclipse.emf.ecore.EReference getUMLClassifier_TargetedByAssociationEnds() -> getUMLClassifier_TargetedByAssociationEnds
    org.eclipse.emf.ecore.EReference getUMLClassifier_Package() -> getUMLClassifier_Package
    org.eclipse.emf.ecore.EClass getUMLType() -> getUMLType
    org.eclipse.emf.ecore.EReference getUMLType_UsedByElements() -> getUMLType_UsedByElements
    org.eclipse.emf.ecore.EClass getUMLTypedElement() -> getUMLTypedElement
    org.eclipse.emf.ecore.EReference getUMLTypedElement_Type() -> getUMLTypedElement_Type
    org.eclipse.emf.ecore.EClass getUMLGeneralizableElement() -> getUMLGeneralizableElement
    org.eclipse.emf.ecore.EReference getUMLGeneralizableElement_Specializations() -> getUMLGeneralizableElement_Specializations
    org.eclipse.emf.ecore.EReference getUMLGeneralizableElement_Generalizations() -> getUMLGeneralizableElement_Generalizations
    org.eclipse.emf.ecore.EClass getUMLGeneralization() -> getUMLGeneralization
    org.eclipse.emf.ecore.EReference getUMLGeneralization_SpecialElement() -> getUMLGeneralization_SpecialElement
    org.eclipse.emf.ecore.EReference getUMLGeneralization_GeneralElement() -> getUMLGeneralization_GeneralElement
    org.eclipse.emf.ecore.EClass getUMLBindingElement() -> getUMLBindingElement
    org.eclipse.emf.ecore.EReference getUMLBindingElement_TemplateBindings() -> getUMLBindingElement_TemplateBindings
    org.eclipse.emf.ecore.EClass getUMLTemplateBinding() -> getUMLTemplateBinding
    org.eclipse.emf.ecore.EReference getUMLTemplateBinding_FormalParam() -> getUMLTemplateBinding_FormalParam
    org.eclipse.emf.ecore.EAttribute getUMLTemplateBinding_ActualParam() -> getUMLTemplateBinding_ActualParam
    org.eclipse.emf.ecore.EReference getUMLTemplateBinding_Binder() -> getUMLTemplateBinding_Binder
    org.eclipse.emf.ecore.EClass getUMLTemplateParameter() -> getUMLTemplateParameter
    org.eclipse.emf.ecore.EReference getUMLTemplateParameter_TemplateableElement() -> getUMLTemplateParameter_TemplateableElement
    org.eclipse.emf.ecore.EAttribute getUMLTemplateParameter_Type() -> getUMLTemplateParameter_Type
    org.eclipse.emf.ecore.EReference getUMLTemplateParameter_Bindings() -> getUMLTemplateParameter_Bindings
    org.eclipse.emf.ecore.EClass getUMLTemplateableElement() -> getUMLTemplateableElement
    org.eclipse.emf.ecore.EReference getUMLTemplateableElement_TemplateParameters() -> getUMLTemplateableElement_TemplateParameters
    org.eclipse.emf.ecore.EClass getUMLAssociationEnd() -> getUMLAssociationEnd
    org.eclipse.emf.ecore.EReference getUMLAssociationEnd_Association() -> getUMLAssociationEnd_Association
    org.eclipse.emf.ecore.EAttribute getUMLAssociationEnd_Multiplicity() -> getUMLAssociationEnd_Multiplicity
    org.eclipse.emf.ecore.EAttribute getUMLAssociationEnd_IsNavigable() -> getUMLAssociationEnd_IsNavigable
    org.eclipse.emf.ecore.EAttribute getUMLAssociationEnd_Kind() -> getUMLAssociationEnd_Kind
    org.eclipse.emf.ecore.EAttribute getUMLAssociationEnd_IsOrdered() -> getUMLAssociationEnd_IsOrdered
    org.eclipse.emf.ecore.EReference getUMLAssociationEnd_Target() -> getUMLAssociationEnd_Target
    org.eclipse.emf.ecore.EClass getUMLEnumeration() -> getUMLEnumeration
    org.eclipse.emf.ecore.EReference getUMLEnumeration_Literals() -> getUMLEnumeration_Literals
    org.eclipse.emf.ecore.EReference getUMLEnumeration_Package() -> getUMLEnumeration_Package
    org.eclipse.emf.ecore.EClass getUMLLiteral() -> getUMLLiteral
    org.eclipse.emf.ecore.EReference getUMLLiteral_Enumeration() -> getUMLLiteral_Enumeration
    org.eclipse.emf.ecore.EClass getUMLPrimitiveType() -> getUMLPrimitiveType
    org.eclipse.emf.ecore.EReference getUMLPrimitiveType_Package() -> getUMLPrimitiveType_Package
    org.eclipse.emf.ecore.EClass getUMLAssociationClass() -> getUMLAssociationClass
    org.eclipse.emf.ecore.EClass getUMLClass() -> getUMLClass
    org.eclipse.emf.ecore.EAttribute getUMLClass_IsAbstract() -> getUMLClass_IsAbstract
    org.eclipse.emf.ecore.EAttribute getUMLClass_IsFinal() -> getUMLClass_IsFinal
    org.eclipse.emf.ecore.EReference getUMLClass_Operations() -> getUMLClass_Operations
    org.eclipse.emf.ecore.EReference getUMLClass_Attributes() -> getUMLClass_Attributes
    org.eclipse.emf.ecore.EClass getUMLOperation() -> getUMLOperation
    org.eclipse.emf.ecore.EAttribute getUMLOperation_IsAbstract() -> getUMLOperation_IsAbstract
    org.eclipse.emf.ecore.EAttribute getUMLOperation_IsStatic() -> getUMLOperation_IsStatic
    org.eclipse.emf.ecore.EReference getUMLOperation_Interface() -> getUMLOperation_Interface
    org.eclipse.emf.ecore.EReference getUMLOperation_Parameters() -> getUMLOperation_Parameters
    org.eclipse.emf.ecore.EReference getUMLOperation_Class() -> getUMLOperation_Class
    org.eclipse.emf.ecore.EClass getUMLInterface() -> getUMLInterface
    org.eclipse.emf.ecore.EReference getUMLInterface_Operations() -> getUMLInterface_Operations
    org.eclipse.emf.ecore.EClass getUMLParameter() -> getUMLParameter
    org.eclipse.emf.ecore.EAttribute getUMLParameter_Kind() -> getUMLParameter_Kind
    org.eclipse.emf.ecore.EReference getUMLParameter_Operation() -> getUMLParameter_Operation
    org.eclipse.emf.ecore.EClass getUMLAttribute() -> getUMLAttribute
    org.eclipse.emf.ecore.EAttribute getUMLAttribute_IsStatic() -> getUMLAttribute_IsStatic
    org.eclipse.emf.ecore.EAttribute getUMLAttribute_IsFinal() -> getUMLAttribute_IsFinal
    org.eclipse.emf.ecore.EAttribute getUMLAttribute_IsReadOnly() -> getUMLAttribute_IsReadOnly
    org.eclipse.emf.ecore.EReference getUMLAttribute_Class() -> getUMLAttribute_Class
    org.eclipse.emf.ecore.EEnum getUMLAggregationKind() -> getUMLAggregationKind
    org.eclipse.emf.ecore.EEnum getUMLParameterKind() -> getUMLParameterKind
    org.sidiff.uml.model.classes.ClassesFactory getClassesFactory() -> getClassesFactory
org.sidiff.uml.model.classes.ClassesPackage$Literals -> org.sidiff.uml.model.classes.ClassesPackage$Literals:
    org.eclipse.emf.ecore.EClass UML_ASSOCIATION -> UML_ASSOCIATION
    org.eclipse.emf.ecore.EReference UML_ASSOCIATION__ASSOCIATION_ENDS -> UML_ASSOCIATION__ASSOCIATION_ENDS
    org.eclipse.emf.ecore.EReference UML_ASSOCIATION__PACKAGE -> UML_ASSOCIATION__PACKAGE
    org.eclipse.emf.ecore.EClass UML_CLASSIFIER -> UML_CLASSIFIER
    org.eclipse.emf.ecore.EReference UML_CLASSIFIER__TARGETED_BY_ASSOCIATION_ENDS -> UML_CLASSIFIER__TARGETED_BY_ASSOCIATION_ENDS
    org.eclipse.emf.ecore.EReference UML_CLASSIFIER__PACKAGE -> UML_CLASSIFIER__PACKAGE
    org.eclipse.emf.ecore.EClass UML_TYPE -> UML_TYPE
    org.eclipse.emf.ecore.EReference UML_TYPE__USED_BY_ELEMENTS -> UML_TYPE__USED_BY_ELEMENTS
    org.eclipse.emf.ecore.EClass UML_TYPED_ELEMENT -> UML_TYPED_ELEMENT
    org.eclipse.emf.ecore.EReference UML_TYPED_ELEMENT__TYPE -> UML_TYPED_ELEMENT__TYPE
    org.eclipse.emf.ecore.EClass UML_GENERALIZABLE_ELEMENT -> UML_GENERALIZABLE_ELEMENT
    org.eclipse.emf.ecore.EReference UML_GENERALIZABLE_ELEMENT__SPECIALIZATIONS -> UML_GENERALIZABLE_ELEMENT__SPECIALIZATIONS
    org.eclipse.emf.ecore.EReference UML_GENERALIZABLE_ELEMENT__GENERALIZATIONS -> UML_GENERALIZABLE_ELEMENT__GENERALIZATIONS
    org.eclipse.emf.ecore.EClass UML_GENERALIZATION -> UML_GENERALIZATION
    org.eclipse.emf.ecore.EReference UML_GENERALIZATION__SPECIAL_ELEMENT -> UML_GENERALIZATION__SPECIAL_ELEMENT
    org.eclipse.emf.ecore.EReference UML_GENERALIZATION__GENERAL_ELEMENT -> UML_GENERALIZATION__GENERAL_ELEMENT
    org.eclipse.emf.ecore.EClass UML_BINDING_ELEMENT -> UML_BINDING_ELEMENT
    org.eclipse.emf.ecore.EReference UML_BINDING_ELEMENT__TEMPLATE_BINDINGS -> UML_BINDING_ELEMENT__TEMPLATE_BINDINGS
    org.eclipse.emf.ecore.EClass UML_TEMPLATE_BINDING -> UML_TEMPLATE_BINDING
    org.eclipse.emf.ecore.EReference UML_TEMPLATE_BINDING__FORMAL_PARAM -> UML_TEMPLATE_BINDING__FORMAL_PARAM
    org.eclipse.emf.ecore.EAttribute UML_TEMPLATE_BINDING__ACTUAL_PARAM -> UML_TEMPLATE_BINDING__ACTUAL_PARAM
    org.eclipse.emf.ecore.EReference UML_TEMPLATE_BINDING__BINDER -> UML_TEMPLATE_BINDING__BINDER
    org.eclipse.emf.ecore.EClass UML_TEMPLATE_PARAMETER -> UML_TEMPLATE_PARAMETER
    org.eclipse.emf.ecore.EReference UML_TEMPLATE_PARAMETER__TEMPLATEABLE_ELEMENT -> UML_TEMPLATE_PARAMETER__TEMPLATEABLE_ELEMENT
    org.eclipse.emf.ecore.EAttribute UML_TEMPLATE_PARAMETER__TYPE -> UML_TEMPLATE_PARAMETER__TYPE
    org.eclipse.emf.ecore.EReference UML_TEMPLATE_PARAMETER__BINDINGS -> UML_TEMPLATE_PARAMETER__BINDINGS
    org.eclipse.emf.ecore.EClass UML_TEMPLATEABLE_ELEMENT -> UML_TEMPLATEABLE_ELEMENT
    org.eclipse.emf.ecore.EReference UML_TEMPLATEABLE_ELEMENT__TEMPLATE_PARAMETERS -> UML_TEMPLATEABLE_ELEMENT__TEMPLATE_PARAMETERS
    org.eclipse.emf.ecore.EClass UML_ASSOCIATION_END -> UML_ASSOCIATION_END
    org.eclipse.emf.ecore.EReference UML_ASSOCIATION_END__ASSOCIATION -> UML_ASSOCIATION_END__ASSOCIATION
    org.eclipse.emf.ecore.EAttribute UML_ASSOCIATION_END__MULTIPLICITY -> UML_ASSOCIATION_END__MULTIPLICITY
    org.eclipse.emf.ecore.EAttribute UML_ASSOCIATION_END__IS_NAVIGABLE -> UML_ASSOCIATION_END__IS_NAVIGABLE
    org.eclipse.emf.ecore.EAttribute UML_ASSOCIATION_END__KIND -> UML_ASSOCIATION_END__KIND
    org.eclipse.emf.ecore.EAttribute UML_ASSOCIATION_END__IS_ORDERED -> UML_ASSOCIATION_END__IS_ORDERED
    org.eclipse.emf.ecore.EReference UML_ASSOCIATION_END__TARGET -> UML_ASSOCIATION_END__TARGET
    org.eclipse.emf.ecore.EClass UML_ENUMERATION -> UML_ENUMERATION
    org.eclipse.emf.ecore.EReference UML_ENUMERATION__LITERALS -> UML_ENUMERATION__LITERALS
    org.eclipse.emf.ecore.EReference UML_ENUMERATION__PACKAGE -> UML_ENUMERATION__PACKAGE
    org.eclipse.emf.ecore.EClass UML_LITERAL -> UML_LITERAL
    org.eclipse.emf.ecore.EReference UML_LITERAL__ENUMERATION -> UML_LITERAL__ENUMERATION
    org.eclipse.emf.ecore.EClass UML_PRIMITIVE_TYPE -> UML_PRIMITIVE_TYPE
    org.eclipse.emf.ecore.EReference UML_PRIMITIVE_TYPE__PACKAGE -> UML_PRIMITIVE_TYPE__PACKAGE
    org.eclipse.emf.ecore.EClass UML_ASSOCIATION_CLASS -> UML_ASSOCIATION_CLASS
    org.eclipse.emf.ecore.EClass UML_CLASS -> UML_CLASS
    org.eclipse.emf.ecore.EAttribute UML_CLASS__IS_ABSTRACT -> UML_CLASS__IS_ABSTRACT
    org.eclipse.emf.ecore.EAttribute UML_CLASS__IS_FINAL -> UML_CLASS__IS_FINAL
    org.eclipse.emf.ecore.EReference UML_CLASS__OPERATIONS -> UML_CLASS__OPERATIONS
    org.eclipse.emf.ecore.EReference UML_CLASS__ATTRIBUTES -> UML_CLASS__ATTRIBUTES
    org.eclipse.emf.ecore.EClass UML_OPERATION -> UML_OPERATION
    org.eclipse.emf.ecore.EAttribute UML_OPERATION__IS_ABSTRACT -> UML_OPERATION__IS_ABSTRACT
    org.eclipse.emf.ecore.EAttribute UML_OPERATION__IS_STATIC -> UML_OPERATION__IS_STATIC
    org.eclipse.emf.ecore.EReference UML_OPERATION__INTERFACE -> UML_OPERATION__INTERFACE
    org.eclipse.emf.ecore.EReference UML_OPERATION__PARAMETERS -> UML_OPERATION__PARAMETERS
    org.eclipse.emf.ecore.EReference UML_OPERATION__CLASS -> UML_OPERATION__CLASS
    org.eclipse.emf.ecore.EClass UML_INTERFACE -> UML_INTERFACE
    org.eclipse.emf.ecore.EReference UML_INTERFACE__OPERATIONS -> UML_INTERFACE__OPERATIONS
    org.eclipse.emf.ecore.EClass UML_PARAMETER -> UML_PARAMETER
    org.eclipse.emf.ecore.EAttribute UML_PARAMETER__KIND -> UML_PARAMETER__KIND
    org.eclipse.emf.ecore.EReference UML_PARAMETER__OPERATION -> UML_PARAMETER__OPERATION
    org.eclipse.emf.ecore.EClass UML_ATTRIBUTE -> UML_ATTRIBUTE
    org.eclipse.emf.ecore.EAttribute UML_ATTRIBUTE__IS_STATIC -> UML_ATTRIBUTE__IS_STATIC
    org.eclipse.emf.ecore.EAttribute UML_ATTRIBUTE__IS_FINAL -> UML_ATTRIBUTE__IS_FINAL
    org.eclipse.emf.ecore.EAttribute UML_ATTRIBUTE__IS_READ_ONLY -> UML_ATTRIBUTE__IS_READ_ONLY
    org.eclipse.emf.ecore.EReference UML_ATTRIBUTE__CLASS -> UML_ATTRIBUTE__CLASS
    org.eclipse.emf.ecore.EEnum UML_AGGREGATION_KIND -> UML_AGGREGATION_KIND
    org.eclipse.emf.ecore.EEnum UML_PARAMETER_KIND -> UML_PARAMETER_KIND
org.sidiff.uml.model.classes.UMLAggregationKind -> org.sidiff.uml.model.classes.UMLAggregationKind:
    org.sidiff.uml.model.classes.UMLAggregationKind NONE -> NONE
    org.sidiff.uml.model.classes.UMLAggregationKind SHARED -> SHARED
    org.sidiff.uml.model.classes.UMLAggregationKind COMPOSITE -> COMPOSITE
    int NONE_VALUE -> NONE_VALUE
    int SHARED_VALUE -> SHARED_VALUE
    int COMPOSITE_VALUE -> COMPOSITE_VALUE
    org.sidiff.uml.model.classes.UMLAggregationKind[] VALUES_ARRAY -> VALUES_ARRAY
    java.util.List VALUES -> VALUES
    int value -> value
    java.lang.String name -> name
    java.lang.String literal -> literal
    org.sidiff.uml.model.classes.UMLAggregationKind[] ENUM$VALUES -> ENUM$VALUES
    org.sidiff.uml.model.classes.UMLAggregationKind get(java.lang.String) -> get
    org.sidiff.uml.model.classes.UMLAggregationKind getByName(java.lang.String) -> getByName
    org.sidiff.uml.model.classes.UMLAggregationKind get(int) -> get
    int getValue() -> getValue
    java.lang.String getName() -> getName
    java.lang.String getLiteral() -> getLiteral
    java.lang.String toString() -> toString
    org.sidiff.uml.model.classes.UMLAggregationKind[] values() -> values
    org.sidiff.uml.model.classes.UMLAggregationKind valueOf(java.lang.String) -> valueOf
org.sidiff.uml.model.classes.UMLAssociation -> org.sidiff.uml.model.classes.UMLAssociation:
    org.eclipse.emf.common.util.EList getAssociationEnds() -> getAssociationEnds
    org.sidiff.uml.model.core.UMLPackage getPackage() -> getPackage
    void setPackage(org.sidiff.uml.model.core.UMLPackage) -> setPackage
org.sidiff.uml.model.classes.UMLAssociationClass -> org.sidiff.uml.model.classes.UMLAssociationClass:
org.sidiff.uml.model.classes.UMLAssociationEnd -> org.sidiff.uml.model.classes.UMLAssociationEnd:
    org.sidiff.uml.model.classes.UMLAssociation getAssociation() -> getAssociation
    void setAssociation(org.sidiff.uml.model.classes.UMLAssociation) -> setAssociation
    java.lang.String getMultiplicity() -> getMultiplicity
    void setMultiplicity(java.lang.String) -> setMultiplicity
    boolean isIsNavigable() -> isIsNavigable
    void setIsNavigable(boolean) -> setIsNavigable
    org.sidiff.uml.model.classes.UMLAggregationKind getKind() -> getKind
    void setKind(org.sidiff.uml.model.classes.UMLAggregationKind) -> setKind
    boolean isIsOrdered() -> isIsOrdered
    void setIsOrdered(boolean) -> setIsOrdered
    org.sidiff.uml.model.classes.UMLClassifier getTarget() -> getTarget
    void setTarget(org.sidiff.uml.model.classes.UMLClassifier) -> setTarget
org.sidiff.uml.model.classes.UMLAttribute -> org.sidiff.uml.model.classes.UMLAttribute:
    boolean isIsStatic() -> isIsStatic
    void setIsStatic(boolean) -> setIsStatic
    boolean isIsFinal() -> isIsFinal
    void setIsFinal(boolean) -> setIsFinal
    boolean isIsReadOnly() -> isIsReadOnly
    void setIsReadOnly(boolean) -> setIsReadOnly
    org.sidiff.uml.model.classes.UMLClass getClass_() -> getClass_
    void setClass(org.sidiff.uml.model.classes.UMLClass) -> setClass
org.sidiff.uml.model.classes.UMLBindingElement -> org.sidiff.uml.model.classes.UMLBindingElement:
    org.eclipse.emf.common.util.EList getTemplateBindings() -> getTemplateBindings
org.sidiff.uml.model.classes.UMLClass -> org.sidiff.uml.model.classes.UMLClass:
    boolean isIsAbstract() -> isIsAbstract
    void setIsAbstract(boolean) -> setIsAbstract
    boolean isIsFinal() -> isIsFinal
    void setIsFinal(boolean) -> setIsFinal
    org.eclipse.emf.common.util.EList getOperations() -> getOperations
    org.eclipse.emf.common.util.EList getAttributes() -> getAttributes
org.sidiff.uml.model.classes.UMLClassifier -> org.sidiff.uml.model.classes.UMLClassifier:
    org.eclipse.emf.common.util.EList getTargetedByAssociationEnds() -> getTargetedByAssociationEnds
    org.sidiff.uml.model.core.UMLPackage getPackage() -> getPackage
    void setPackage(org.sidiff.uml.model.core.UMLPackage) -> setPackage
org.sidiff.uml.model.classes.UMLEnumeration -> org.sidiff.uml.model.classes.UMLEnumeration:
    org.eclipse.emf.common.util.EList getLiterals() -> getLiterals
    org.sidiff.uml.model.core.UMLPackage getPackage() -> getPackage
    void setPackage(org.sidiff.uml.model.core.UMLPackage) -> setPackage
org.sidiff.uml.model.classes.UMLGeneralizableElement -> org.sidiff.uml.model.classes.UMLGeneralizableElement:
    org.eclipse.emf.common.util.EList getSpecializations() -> getSpecializations
    org.eclipse.emf.common.util.EList getGeneralizations() -> getGeneralizations
org.sidiff.uml.model.classes.UMLGeneralization -> org.sidiff.uml.model.classes.UMLGeneralization:
    org.sidiff.uml.model.classes.UMLGeneralizableElement getSpecialElement() -> getSpecialElement
    void setSpecialElement(org.sidiff.uml.model.classes.UMLGeneralizableElement) -> setSpecialElement
    org.sidiff.uml.model.classes.UMLGeneralizableElement getGeneralElement() -> getGeneralElement
    void setGeneralElement(org.sidiff.uml.model.classes.UMLGeneralizableElement) -> setGeneralElement
org.sidiff.uml.model.classes.UMLInterface -> org.sidiff.uml.model.classes.UMLInterface:
    org.eclipse.emf.common.util.EList getOperations() -> getOperations
org.sidiff.uml.model.classes.UMLLiteral -> org.sidiff.uml.model.classes.UMLLiteral:
    org.sidiff.uml.model.classes.UMLEnumeration getEnumeration() -> getEnumeration
    void setEnumeration(org.sidiff.uml.model.classes.UMLEnumeration) -> setEnumeration
org.sidiff.uml.model.classes.UMLOperation -> org.sidiff.uml.model.classes.UMLOperation:
    boolean isIsAbstract() -> isIsAbstract
    void setIsAbstract(boolean) -> setIsAbstract
    boolean isIsStatic() -> isIsStatic
    void setIsStatic(boolean) -> setIsStatic
    org.sidiff.uml.model.classes.UMLInterface getInterface() -> getInterface
    void setInterface(org.sidiff.uml.model.classes.UMLInterface) -> setInterface
    org.eclipse.emf.common.util.EList getParameters() -> getParameters
    org.sidiff.uml.model.classes.UMLClass getClass_() -> getClass_
    void setClass(org.sidiff.uml.model.classes.UMLClass) -> setClass
org.sidiff.uml.model.classes.UMLParameter -> org.sidiff.uml.model.classes.UMLParameter:
    org.sidiff.uml.model.classes.UMLParameterKind getKind() -> getKind
    void setKind(org.sidiff.uml.model.classes.UMLParameterKind) -> setKind
    org.sidiff.uml.model.classes.UMLOperation getOperation() -> getOperation
    void setOperation(org.sidiff.uml.model.classes.UMLOperation) -> setOperation
org.sidiff.uml.model.classes.UMLParameterKind -> org.sidiff.uml.model.classes.UMLParameterKind:
    org.sidiff.uml.model.classes.UMLParameterKind IN -> IN
    org.sidiff.uml.model.classes.UMLParameterKind OUT -> OUT
    org.sidiff.uml.model.classes.UMLParameterKind INOUT -> INOUT
    int IN_VALUE -> IN_VALUE
    int OUT_VALUE -> OUT_VALUE
    int INOUT_VALUE -> INOUT_VALUE
    org.sidiff.uml.model.classes.UMLParameterKind[] VALUES_ARRAY -> VALUES_ARRAY
    java.util.List VALUES -> VALUES
    int value -> value
    java.lang.String name -> name
    java.lang.String literal -> literal
    org.sidiff.uml.model.classes.UMLParameterKind[] ENUM$VALUES -> ENUM$VALUES
    org.sidiff.uml.model.classes.UMLParameterKind get(java.lang.String) -> get
    org.sidiff.uml.model.classes.UMLParameterKind getByName(java.lang.String) -> getByName
    org.sidiff.uml.model.classes.UMLParameterKind get(int) -> get
    int getValue() -> getValue
    java.lang.String getName() -> getName
    java.lang.String getLiteral() -> getLiteral
    java.lang.String toString() -> toString
    org.sidiff.uml.model.classes.UMLParameterKind[] values() -> values
    org.sidiff.uml.model.classes.UMLParameterKind valueOf(java.lang.String) -> valueOf
org.sidiff.uml.model.classes.UMLPrimitiveType -> org.sidiff.uml.model.classes.UMLPrimitiveType:
    org.sidiff.uml.model.core.UMLPackage getPackage() -> getPackage
    void setPackage(org.sidiff.uml.model.core.UMLPackage) -> setPackage
org.sidiff.uml.model.classes.UMLTemplateBinding -> org.sidiff.uml.model.classes.UMLTemplateBinding:
    org.sidiff.uml.model.classes.UMLTemplateParameter getFormalParam() -> getFormalParam
    void setFormalParam(org.sidiff.uml.model.classes.UMLTemplateParameter) -> setFormalParam
    java.lang.String getActualParam() -> getActualParam
    void setActualParam(java.lang.String) -> setActualParam
    org.sidiff.uml.model.classes.UMLBindingElement getBinder() -> getBinder
    void setBinder(org.sidiff.uml.model.classes.UMLBindingElement) -> setBinder
org.sidiff.uml.model.classes.UMLTemplateParameter -> org.sidiff.uml.model.classes.UMLTemplateParameter:
    org.sidiff.uml.model.classes.UMLTemplateableElement getTemplateableElement() -> getTemplateableElement
    void setTemplateableElement(org.sidiff.uml.model.classes.UMLTemplateableElement) -> setTemplateableElement
    java.lang.String getType() -> getType
    void setType(java.lang.String) -> setType
    org.eclipse.emf.common.util.EList getBindings() -> getBindings
org.sidiff.uml.model.classes.UMLTemplateableElement -> org.sidiff.uml.model.classes.UMLTemplateableElement:
    org.eclipse.emf.common.util.EList getTemplateParameters() -> getTemplateParameters
org.sidiff.uml.model.classes.UMLType -> org.sidiff.uml.model.classes.UMLType:
    org.eclipse.emf.common.util.EList getUsedByElements() -> getUsedByElements
org.sidiff.uml.model.classes.UMLTypedElement -> org.sidiff.uml.model.classes.UMLTypedElement:
    org.sidiff.uml.model.classes.UMLType getType() -> getType
    void setType(org.sidiff.uml.model.classes.UMLType) -> setType
org.sidiff.uml.model.classes.impl.ClassesFactoryImpl -> org.sidiff.uml.model.classes.impl.ClassesFactoryImpl:
    org.sidiff.uml.model.classes.ClassesFactory init() -> init
    org.eclipse.emf.ecore.EObject create(org.eclipse.emf.ecore.EClass) -> create
    java.lang.Object createFromString(org.eclipse.emf.ecore.EDataType,java.lang.String) -> createFromString
    java.lang.String convertToString(org.eclipse.emf.ecore.EDataType,java.lang.Object) -> convertToString
    org.sidiff.uml.model.classes.UMLAssociation createUMLAssociation() -> createUMLAssociation
    org.sidiff.uml.model.classes.UMLGeneralization createUMLGeneralization() -> createUMLGeneralization
    org.sidiff.uml.model.classes.UMLTemplateBinding createUMLTemplateBinding() -> createUMLTemplateBinding
    org.sidiff.uml.model.classes.UMLTemplateParameter createUMLTemplateParameter() -> createUMLTemplateParameter
    org.sidiff.uml.model.classes.UMLAssociationEnd createUMLAssociationEnd() -> createUMLAssociationEnd
    org.sidiff.uml.model.classes.UMLEnumeration createUMLEnumeration() -> createUMLEnumeration
    org.sidiff.uml.model.classes.UMLLiteral createUMLLiteral() -> createUMLLiteral
    org.sidiff.uml.model.classes.UMLPrimitiveType createUMLPrimitiveType() -> createUMLPrimitiveType
    org.sidiff.uml.model.classes.UMLAssociationClass createUMLAssociationClass() -> createUMLAssociationClass
    org.sidiff.uml.model.classes.UMLClass createUMLClass() -> createUMLClass
    org.sidiff.uml.model.classes.UMLOperation createUMLOperation() -> createUMLOperation
    org.sidiff.uml.model.classes.UMLInterface createUMLInterface() -> createUMLInterface
    org.sidiff.uml.model.classes.UMLParameter createUMLParameter() -> createUMLParameter
    org.sidiff.uml.model.classes.UMLAttribute createUMLAttribute() -> createUMLAttribute
    org.sidiff.uml.model.classes.UMLAggregationKind createUMLAggregationKindFromString(org.eclipse.emf.ecore.EDataType,java.lang.String) -> createUMLAggregationKindFromString
    java.lang.String convertUMLAggregationKindToString(org.eclipse.emf.ecore.EDataType,java.lang.Object) -> convertUMLAggregationKindToString
    org.sidiff.uml.model.classes.UMLParameterKind createUMLParameterKindFromString(org.eclipse.emf.ecore.EDataType,java.lang.String) -> createUMLParameterKindFromString
    java.lang.String convertUMLParameterKindToString(org.eclipse.emf.ecore.EDataType,java.lang.Object) -> convertUMLParameterKindToString
    org.sidiff.uml.model.classes.ClassesPackage getClassesPackage() -> getClassesPackage
    org.sidiff.uml.model.classes.ClassesPackage getPackage() -> getPackage
org.sidiff.uml.model.classes.impl.ClassesPackageImpl -> org.sidiff.uml.model.classes.impl.ClassesPackageImpl:
    org.eclipse.emf.ecore.EClass umlAssociationEClass -> umlAssociationEClass
    org.eclipse.emf.ecore.EClass umlClassifierEClass -> umlClassifierEClass
    org.eclipse.emf.ecore.EClass umlTypeEClass -> umlTypeEClass
    org.eclipse.emf.ecore.EClass umlTypedElementEClass -> umlTypedElementEClass
    org.eclipse.emf.ecore.EClass umlGeneralizableElementEClass -> umlGeneralizableElementEClass
    org.eclipse.emf.ecore.EClass umlGeneralizationEClass -> umlGeneralizationEClass
    org.eclipse.emf.ecore.EClass umlBindingElementEClass -> umlBindingElementEClass
    org.eclipse.emf.ecore.EClass umlTemplateBindingEClass -> umlTemplateBindingEClass
    org.eclipse.emf.ecore.EClass umlTemplateParameterEClass -> umlTemplateParameterEClass
    org.eclipse.emf.ecore.EClass umlTemplateableElementEClass -> umlTemplateableElementEClass
    org.eclipse.emf.ecore.EClass umlAssociationEndEClass -> umlAssociationEndEClass
    org.eclipse.emf.ecore.EClass umlEnumerationEClass -> umlEnumerationEClass
    org.eclipse.emf.ecore.EClass umlLiteralEClass -> umlLiteralEClass
    org.eclipse.emf.ecore.EClass umlPrimitiveTypeEClass -> umlPrimitiveTypeEClass
    org.eclipse.emf.ecore.EClass umlAssociationClassEClass -> umlAssociationClassEClass
    org.eclipse.emf.ecore.EClass umlClassEClass -> umlClassEClass
    org.eclipse.emf.ecore.EClass umlOperationEClass -> umlOperationEClass
    org.eclipse.emf.ecore.EClass umlInterfaceEClass -> umlInterfaceEClass
    org.eclipse.emf.ecore.EClass umlParameterEClass -> umlParameterEClass
    org.eclipse.emf.ecore.EClass umlAttributeEClass -> umlAttributeEClass
    org.eclipse.emf.ecore.EEnum umlAggregationKindEEnum -> umlAggregationKindEEnum
    org.eclipse.emf.ecore.EEnum umlParameterKindEEnum -> umlParameterKindEEnum
    boolean isInited -> isInited
    boolean isCreated -> isCreated
    boolean isInitialized -> isInitialized
    org.sidiff.uml.model.classes.ClassesPackage init() -> init
    org.eclipse.emf.ecore.EClass getUMLAssociation() -> getUMLAssociation
    org.eclipse.emf.ecore.EReference getUMLAssociation_AssociationEnds() -> getUMLAssociation_AssociationEnds
    org.eclipse.emf.ecore.EReference getUMLAssociation_Package() -> getUMLAssociation_Package
    org.eclipse.emf.ecore.EClass getUMLClassifier() -> getUMLClassifier
    org.eclipse.emf.ecore.EReference getUMLClassifier_TargetedByAssociationEnds() -> getUMLClassifier_TargetedByAssociationEnds
    org.eclipse.emf.ecore.EReference getUMLClassifier_Package() -> getUMLClassifier_Package
    org.eclipse.emf.ecore.EClass getUMLType() -> getUMLType
    org.eclipse.emf.ecore.EReference getUMLType_UsedByElements() -> getUMLType_UsedByElements
    org.eclipse.emf.ecore.EClass getUMLTypedElement() -> getUMLTypedElement
    org.eclipse.emf.ecore.EReference getUMLTypedElement_Type() -> getUMLTypedElement_Type
    org.eclipse.emf.ecore.EClass getUMLGeneralizableElement() -> getUMLGeneralizableElement
    org.eclipse.emf.ecore.EReference getUMLGeneralizableElement_Specializations() -> getUMLGeneralizableElement_Specializations
    org.eclipse.emf.ecore.EReference getUMLGeneralizableElement_Generalizations() -> getUMLGeneralizableElement_Generalizations
    org.eclipse.emf.ecore.EClass getUMLGeneralization() -> getUMLGeneralization
    org.eclipse.emf.ecore.EReference getUMLGeneralization_SpecialElement() -> getUMLGeneralization_SpecialElement
    org.eclipse.emf.ecore.EReference getUMLGeneralization_GeneralElement() -> getUMLGeneralization_GeneralElement
    org.eclipse.emf.ecore.EClass getUMLBindingElement() -> getUMLBindingElement
    org.eclipse.emf.ecore.EReference getUMLBindingElement_TemplateBindings() -> getUMLBindingElement_TemplateBindings
    org.eclipse.emf.ecore.EClass getUMLTemplateBinding() -> getUMLTemplateBinding
    org.eclipse.emf.ecore.EReference getUMLTemplateBinding_FormalParam() -> getUMLTemplateBinding_FormalParam
    org.eclipse.emf.ecore.EAttribute getUMLTemplateBinding_ActualParam() -> getUMLTemplateBinding_ActualParam
    org.eclipse.emf.ecore.EReference getUMLTemplateBinding_Binder() -> getUMLTemplateBinding_Binder
    org.eclipse.emf.ecore.EClass getUMLTemplateParameter() -> getUMLTemplateParameter
    org.eclipse.emf.ecore.EReference getUMLTemplateParameter_TemplateableElement() -> getUMLTemplateParameter_TemplateableElement
    org.eclipse.emf.ecore.EAttribute getUMLTemplateParameter_Type() -> getUMLTemplateParameter_Type
    org.eclipse.emf.ecore.EReference getUMLTemplateParameter_Bindings() -> getUMLTemplateParameter_Bindings
    org.eclipse.emf.ecore.EClass getUMLTemplateableElement() -> getUMLTemplateableElement
    org.eclipse.emf.ecore.EReference getUMLTemplateableElement_TemplateParameters() -> getUMLTemplateableElement_TemplateParameters
    org.eclipse.emf.ecore.EClass getUMLAssociationEnd() -> getUMLAssociationEnd
    org.eclipse.emf.ecore.EReference getUMLAssociationEnd_Association() -> getUMLAssociationEnd_Association
    org.eclipse.emf.ecore.EAttribute getUMLAssociationEnd_Multiplicity() -> getUMLAssociationEnd_Multiplicity
    org.eclipse.emf.ecore.EAttribute getUMLAssociationEnd_IsNavigable() -> getUMLAssociationEnd_IsNavigable
    org.eclipse.emf.ecore.EAttribute getUMLAssociationEnd_Kind() -> getUMLAssociationEnd_Kind
    org.eclipse.emf.ecore.EAttribute getUMLAssociationEnd_IsOrdered() -> getUMLAssociationEnd_IsOrdered
    org.eclipse.emf.ecore.EReference getUMLAssociationEnd_Target() -> getUMLAssociationEnd_Target
    org.eclipse.emf.ecore.EClass getUMLEnumeration() -> getUMLEnumeration
    org.eclipse.emf.ecore.EReference getUMLEnumeration_Literals() -> getUMLEnumeration_Literals
    org.eclipse.emf.ecore.EReference getUMLEnumeration_Package() -> getUMLEnumeration_Package
    org.eclipse.emf.ecore.EClass getUMLLiteral() -> getUMLLiteral
    org.eclipse.emf.ecore.EReference getUMLLiteral_Enumeration() -> getUMLLiteral_Enumeration
    org.eclipse.emf.ecore.EClass getUMLPrimitiveType() -> getUMLPrimitiveType
    org.eclipse.emf.ecore.EReference getUMLPrimitiveType_Package() -> getUMLPrimitiveType_Package
    org.eclipse.emf.ecore.EClass getUMLAssociationClass() -> getUMLAssociationClass
    org.eclipse.emf.ecore.EClass getUMLClass() -> getUMLClass
    org.eclipse.emf.ecore.EAttribute getUMLClass_IsAbstract() -> getUMLClass_IsAbstract
    org.eclipse.emf.ecore.EAttribute getUMLClass_IsFinal() -> getUMLClass_IsFinal
    org.eclipse.emf.ecore.EReference getUMLClass_Operations() -> getUMLClass_Operations
    org.eclipse.emf.ecore.EReference getUMLClass_Attributes() -> getUMLClass_Attributes
    org.eclipse.emf.ecore.EClass getUMLOperation() -> getUMLOperation
    org.eclipse.emf.ecore.EAttribute getUMLOperation_IsAbstract() -> getUMLOperation_IsAbstract
    org.eclipse.emf.ecore.EAttribute getUMLOperation_IsStatic() -> getUMLOperation_IsStatic
    org.eclipse.emf.ecore.EReference getUMLOperation_Interface() -> getUMLOperation_Interface
    org.eclipse.emf.ecore.EReference getUMLOperation_Parameters() -> getUMLOperation_Parameters
    org.eclipse.emf.ecore.EReference getUMLOperation_Class() -> getUMLOperation_Class
    org.eclipse.emf.ecore.EClass getUMLInterface() -> getUMLInterface
    org.eclipse.emf.ecore.EReference getUMLInterface_Operations() -> getUMLInterface_Operations
    org.eclipse.emf.ecore.EClass getUMLParameter() -> getUMLParameter
    org.eclipse.emf.ecore.EAttribute getUMLParameter_Kind() -> getUMLParameter_Kind
    org.eclipse.emf.ecore.EReference getUMLParameter_Operation() -> getUMLParameter_Operation
    org.eclipse.emf.ecore.EClass getUMLAttribute() -> getUMLAttribute
    org.eclipse.emf.ecore.EAttribute getUMLAttribute_IsStatic() -> getUMLAttribute_IsStatic
    org.eclipse.emf.ecore.EAttribute getUMLAttribute_IsFinal() -> getUMLAttribute_IsFinal
    org.eclipse.emf.ecore.EAttribute getUMLAttribute_IsReadOnly() -> getUMLAttribute_IsReadOnly
    org.eclipse.emf.ecore.EReference getUMLAttribute_Class() -> getUMLAttribute_Class
    org.eclipse.emf.ecore.EEnum getUMLAggregationKind() -> getUMLAggregationKind
    org.eclipse.emf.ecore.EEnum getUMLParameterKind() -> getUMLParameterKind
    org.sidiff.uml.model.classes.ClassesFactory getClassesFactory() -> getClassesFactory
    void createPackageContents() -> createPackageContents
    void initializePackageContents() -> initializePackageContents
    void createINCOMINGAnnotations() -> createINCOMINGAnnotations
    void createIGNOREDIFFAnnotations() -> createIGNOREDIFFAnnotations
    void createAbsolutePositionAnnotations() -> createAbsolutePositionAnnotations
org.sidiff.uml.model.classes.impl.UMLAssociationClassImpl -> org.sidiff.uml.model.classes.impl.UMLAssociationClassImpl:
    org.eclipse.emf.ecore.EClass eStaticClass() -> eStaticClass
org.sidiff.uml.model.classes.impl.UMLAssociationEndImpl -> org.sidiff.uml.model.classes.impl.UMLAssociationEndImpl:
    org.eclipse.emf.common.util.EList stereotypes -> stereotypes
    java.lang.String MULTIPLICITY_EDEFAULT -> MULTIPLICITY_EDEFAULT
    java.lang.String multiplicity -> multiplicity
    boolean IS_NAVIGABLE_EDEFAULT -> IS_NAVIGABLE_EDEFAULT
    boolean isNavigable -> isNavigable
    org.sidiff.uml.model.classes.UMLAggregationKind KIND_EDEFAULT -> KIND_EDEFAULT
    org.sidiff.uml.model.classes.UMLAggregationKind kind -> kind
    boolean IS_ORDERED_EDEFAULT -> IS_ORDERED_EDEFAULT
    boolean isOrdered -> isOrdered
    org.sidiff.uml.model.classes.UMLClassifier target -> target
    org.eclipse.emf.ecore.EClass eStaticClass() -> eStaticClass
    org.eclipse.emf.common.util.EList getStereotypes() -> getStereotypes
    org.sidiff.uml.model.classes.UMLAssociation getAssociation() -> getAssociation
    org.eclipse.emf.common.notify.NotificationChain basicSetAssociation(org.sidiff.uml.model.classes.UMLAssociation,org.eclipse.emf.common.notify.NotificationChain) -> basicSetAssociation
    void setAssociation(org.sidiff.uml.model.classes.UMLAssociation) -> setAssociation
    java.lang.String getMultiplicity() -> getMultiplicity
    void setMultiplicity(java.lang.String) -> setMultiplicity
    boolean isIsNavigable() -> isIsNavigable
    void setIsNavigable(boolean) -> setIsNavigable
    org.sidiff.uml.model.classes.UMLAggregationKind getKind() -> getKind
    void setKind(org.sidiff.uml.model.classes.UMLAggregationKind) -> setKind
    boolean isIsOrdered() -> isIsOrdered
    void setIsOrdered(boolean) -> setIsOrdered
    org.sidiff.uml.model.classes.UMLClassifier getTarget() -> getTarget
    org.sidiff.uml.model.classes.UMLClassifier basicGetTarget() -> basicGetTarget
    org.eclipse.emf.common.notify.NotificationChain basicSetTarget(org.sidiff.uml.model.classes.UMLClassifier,org.eclipse.emf.common.notify.NotificationChain) -> basicSetTarget
    void setTarget(org.sidiff.uml.model.classes.UMLClassifier) -> setTarget
    org.eclipse.emf.common.notify.NotificationChain eInverseAdd(org.eclipse.emf.ecore.InternalEObject,int,org.eclipse.emf.common.notify.NotificationChain) -> eInverseAdd
    org.eclipse.emf.common.notify.NotificationChain eInverseRemove(org.eclipse.emf.ecore.InternalEObject,int,org.eclipse.emf.common.notify.NotificationChain) -> eInverseRemove
    org.eclipse.emf.common.notify.NotificationChain eBasicRemoveFromContainerFeature(org.eclipse.emf.common.notify.NotificationChain) -> eBasicRemoveFromContainerFeature
    java.lang.Object eGet(int,boolean,boolean) -> eGet
    void eSet(int,java.lang.Object) -> eSet
    void eUnset(int) -> eUnset
    boolean eIsSet(int) -> eIsSet
    int eBaseStructuralFeatureID(int,java.lang.Class) -> eBaseStructuralFeatureID
    int eDerivedStructuralFeatureID(int,java.lang.Class) -> eDerivedStructuralFeatureID
    java.lang.String toString() -> toString
org.sidiff.uml.model.classes.impl.UMLAssociationImpl -> org.sidiff.uml.model.classes.impl.UMLAssociationImpl:
    org.eclipse.emf.common.util.EList specializations -> specializations
    org.eclipse.emf.common.util.EList generalizations -> generalizations
    org.eclipse.emf.common.util.EList stereotypes -> stereotypes
    org.eclipse.emf.common.util.EList associationEnds -> associationEnds
    org.eclipse.emf.ecore.EClass eStaticClass() -> eStaticClass
    org.eclipse.emf.common.util.EList getSpecializations() -> getSpecializations
    org.eclipse.emf.common.util.EList getGeneralizations() -> getGeneralizations
    org.eclipse.emf.common.util.EList getStereotypes() -> getStereotypes
    org.eclipse.emf.common.util.EList getAssociationEnds() -> getAssociationEnds
    org.sidiff.uml.model.core.UMLPackage getPackage() -> getPackage
    org.eclipse.emf.common.notify.NotificationChain basicSetPackage(org.sidiff.uml.model.core.UMLPackage,org.eclipse.emf.common.notify.NotificationChain) -> basicSetPackage
    void setPackage(org.sidiff.uml.model.core.UMLPackage) -> setPackage
    org.eclipse.emf.common.notify.NotificationChain eInverseAdd(org.eclipse.emf.ecore.InternalEObject,int,org.eclipse.emf.common.notify.NotificationChain) -> eInverseAdd
    org.eclipse.emf.common.notify.NotificationChain eInverseRemove(org.eclipse.emf.ecore.InternalEObject,int,org.eclipse.emf.common.notify.NotificationChain) -> eInverseRemove
    org.eclipse.emf.common.notify.NotificationChain eBasicRemoveFromContainerFeature(org.eclipse.emf.common.notify.NotificationChain) -> eBasicRemoveFromContainerFeature
    java.lang.Object eGet(int,boolean,boolean) -> eGet
    void eSet(int,java.lang.Object) -> eSet
    void eUnset(int) -> eUnset
    boolean eIsSet(int) -> eIsSet
    int eBaseStructuralFeatureID(int,java.lang.Class) -> eBaseStructuralFeatureID
    int eDerivedStructuralFeatureID(int,java.lang.Class) -> eDerivedStructuralFeatureID
org.sidiff.uml.model.classes.impl.UMLAttributeImpl -> org.sidiff.uml.model.classes.impl.UMLAttributeImpl:
    org.eclipse.emf.common.util.EList stereotypes -> stereotypes
    org.sidiff.uml.model.classes.UMLType type -> type
    org.sidiff.uml.model.core.UMLVisibility VISIBILITY_EDEFAULT -> VISIBILITY_EDEFAULT
    org.sidiff.uml.model.core.UMLVisibility visibility -> visibility
    boolean IS_STATIC_EDEFAULT -> IS_STATIC_EDEFAULT
    boolean isStatic -> isStatic
    boolean IS_FINAL_EDEFAULT -> IS_FINAL_EDEFAULT
    boolean isFinal -> isFinal
    boolean IS_READ_ONLY_EDEFAULT -> IS_READ_ONLY_EDEFAULT
    boolean isReadOnly -> isReadOnly
    org.eclipse.emf.ecore.EClass eStaticClass() -> eStaticClass
    org.eclipse.emf.common.util.EList getStereotypes() -> getStereotypes
    org.sidiff.uml.model.classes.UMLType getType() -> getType
    org.sidiff.uml.model.classes.UMLType basicGetType() -> basicGetType
    org.eclipse.emf.common.notify.NotificationChain basicSetType(org.sidiff.uml.model.classes.UMLType,org.eclipse.emf.common.notify.NotificationChain) -> basicSetType
    void setType(org.sidiff.uml.model.classes.UMLType) -> setType
    org.sidiff.uml.model.core.UMLVisibility getVisibility() -> getVisibility
    void setVisibility(org.sidiff.uml.model.core.UMLVisibility) -> setVisibility
    boolean isIsStatic() -> isIsStatic
    void setIsStatic(boolean) -> setIsStatic
    boolean isIsFinal() -> isIsFinal
    void setIsFinal(boolean) -> setIsFinal
    boolean isIsReadOnly() -> isIsReadOnly
    void setIsReadOnly(boolean) -> setIsReadOnly
    org.sidiff.uml.model.classes.UMLClass getClass_() -> getClass_
    org.eclipse.emf.common.notify.NotificationChain basicSetClass(org.sidiff.uml.model.classes.UMLClass,org.eclipse.emf.common.notify.NotificationChain) -> basicSetClass
    void setClass(org.sidiff.uml.model.classes.UMLClass) -> setClass
    org.eclipse.emf.common.notify.NotificationChain eInverseAdd(org.eclipse.emf.ecore.InternalEObject,int,org.eclipse.emf.common.notify.NotificationChain) -> eInverseAdd
    org.eclipse.emf.common.notify.NotificationChain eInverseRemove(org.eclipse.emf.ecore.InternalEObject,int,org.eclipse.emf.common.notify.NotificationChain) -> eInverseRemove
    org.eclipse.emf.common.notify.NotificationChain eBasicRemoveFromContainerFeature(org.eclipse.emf.common.notify.NotificationChain) -> eBasicRemoveFromContainerFeature
    java.lang.Object eGet(int,boolean,boolean) -> eGet
    void eSet(int,java.lang.Object) -> eSet
    void eUnset(int) -> eUnset
    boolean eIsSet(int) -> eIsSet
    int eBaseStructuralFeatureID(int,java.lang.Class) -> eBaseStructuralFeatureID
    int eDerivedStructuralFeatureID(int,java.lang.Class) -> eDerivedStructuralFeatureID
    java.lang.String toString() -> toString
org.sidiff.uml.model.classes.impl.UMLBindingElementImpl -> org.sidiff.uml.model.classes.impl.UMLBindingElementImpl:
    org.eclipse.emf.common.util.EList templateBindings -> templateBindings
    org.eclipse.emf.ecore.EClass eStaticClass() -> eStaticClass
    org.eclipse.emf.common.util.EList getTemplateBindings() -> getTemplateBindings
    org.eclipse.emf.common.notify.NotificationChain eInverseAdd(org.eclipse.emf.ecore.InternalEObject,int,org.eclipse.emf.common.notify.NotificationChain) -> eInverseAdd
    org.eclipse.emf.common.notify.NotificationChain eInverseRemove(org.eclipse.emf.ecore.InternalEObject,int,org.eclipse.emf.common.notify.NotificationChain) -> eInverseRemove
    java.lang.Object eGet(int,boolean,boolean) -> eGet
    void eSet(int,java.lang.Object) -> eSet
    void eUnset(int) -> eUnset
    boolean eIsSet(int) -> eIsSet
org.sidiff.uml.model.classes.impl.UMLClassImpl -> org.sidiff.uml.model.classes.impl.UMLClassImpl:
    boolean IS_ABSTRACT_EDEFAULT -> IS_ABSTRACT_EDEFAULT
    boolean isAbstract -> isAbstract
    boolean IS_FINAL_EDEFAULT -> IS_FINAL_EDEFAULT
    boolean isFinal -> isFinal
    org.eclipse.emf.common.util.EList operations -> operations
    org.eclipse.emf.common.util.EList attributes -> attributes
    org.eclipse.emf.ecore.EClass eStaticClass() -> eStaticClass
    boolean isIsAbstract() -> isIsAbstract
    void setIsAbstract(boolean) -> setIsAbstract
    boolean isIsFinal() -> isIsFinal
    void setIsFinal(boolean) -> setIsFinal
    org.eclipse.emf.common.util.EList getOperations() -> getOperations
    org.eclipse.emf.common.util.EList getAttributes() -> getAttributes
    org.eclipse.emf.common.notify.NotificationChain eInverseAdd(org.eclipse.emf.ecore.InternalEObject,int,org.eclipse.emf.common.notify.NotificationChain) -> eInverseAdd
    org.eclipse.emf.common.notify.NotificationChain eInverseRemove(org.eclipse.emf.ecore.InternalEObject,int,org.eclipse.emf.common.notify.NotificationChain) -> eInverseRemove
    java.lang.Object eGet(int,boolean,boolean) -> eGet
    void eSet(int,java.lang.Object) -> eSet
    void eUnset(int) -> eUnset
    boolean eIsSet(int) -> eIsSet
    java.lang.String toString() -> toString
org.sidiff.uml.model.classes.impl.UMLClassifierImpl -> org.sidiff.uml.model.classes.impl.UMLClassifierImpl:
    org.eclipse.emf.common.util.EList specializations -> specializations
    org.eclipse.emf.common.util.EList generalizations -> generalizations
    org.eclipse.emf.common.util.EList templateBindings -> templateBindings
    org.eclipse.emf.common.util.EList stereotypes -> stereotypes
    org.eclipse.emf.common.util.EList templateParameters -> templateParameters
    org.sidiff.uml.model.core.UMLVisibility VISIBILITY_EDEFAULT -> VISIBILITY_EDEFAULT
    org.sidiff.uml.model.core.UMLVisibility visibility -> visibility
    org.eclipse.emf.common.util.EList targetedByAssociationEnds -> targetedByAssociationEnds
    org.eclipse.emf.ecore.EClass eStaticClass() -> eStaticClass
    org.eclipse.emf.common.util.EList getSpecializations() -> getSpecializations
    org.eclipse.emf.common.util.EList getGeneralizations() -> getGeneralizations
    org.eclipse.emf.common.util.EList getTemplateBindings() -> getTemplateBindings
    org.eclipse.emf.common.util.EList getStereotypes() -> getStereotypes
    org.eclipse.emf.common.util.EList getTemplateParameters() -> getTemplateParameters
    org.sidiff.uml.model.core.UMLVisibility getVisibility() -> getVisibility
    void setVisibility(org.sidiff.uml.model.core.UMLVisibility) -> setVisibility
    org.eclipse.emf.common.util.EList getTargetedByAssociationEnds() -> getTargetedByAssociationEnds
    org.sidiff.uml.model.core.UMLPackage getPackage() -> getPackage
    org.eclipse.emf.common.notify.NotificationChain basicSetPackage(org.sidiff.uml.model.core.UMLPackage,org.eclipse.emf.common.notify.NotificationChain) -> basicSetPackage
    void setPackage(org.sidiff.uml.model.core.UMLPackage) -> setPackage
    org.eclipse.emf.common.notify.NotificationChain eInverseAdd(org.eclipse.emf.ecore.InternalEObject,int,org.eclipse.emf.common.notify.NotificationChain) -> eInverseAdd
    org.eclipse.emf.common.notify.NotificationChain eInverseRemove(org.eclipse.emf.ecore.InternalEObject,int,org.eclipse.emf.common.notify.NotificationChain) -> eInverseRemove
    org.eclipse.emf.common.notify.NotificationChain eBasicRemoveFromContainerFeature(org.eclipse.emf.common.notify.NotificationChain) -> eBasicRemoveFromContainerFeature
    java.lang.Object eGet(int,boolean,boolean) -> eGet
    void eSet(int,java.lang.Object) -> eSet
    void eUnset(int) -> eUnset
    boolean eIsSet(int) -> eIsSet
    int eBaseStructuralFeatureID(int,java.lang.Class) -> eBaseStructuralFeatureID
    int eDerivedStructuralFeatureID(int,java.lang.Class) -> eDerivedStructuralFeatureID
    java.lang.String toString() -> toString
org.sidiff.uml.model.classes.impl.UMLEnumerationImpl -> org.sidiff.uml.model.classes.impl.UMLEnumerationImpl:
    org.sidiff.uml.model.core.UMLVisibility VISIBILITY_EDEFAULT -> VISIBILITY_EDEFAULT
    org.sidiff.uml.model.core.UMLVisibility visibility -> visibility
    org.eclipse.emf.common.util.EList literals -> literals
    org.eclipse.emf.ecore.EClass eStaticClass() -> eStaticClass
    org.sidiff.uml.model.core.UMLVisibility getVisibility() -> getVisibility
    void setVisibility(org.sidiff.uml.model.core.UMLVisibility) -> setVisibility
    org.eclipse.emf.common.util.EList getLiterals() -> getLiterals
    org.sidiff.uml.model.core.UMLPackage getPackage() -> getPackage
    org.eclipse.emf.common.notify.NotificationChain basicSetPackage(org.sidiff.uml.model.core.UMLPackage,org.eclipse.emf.common.notify.NotificationChain) -> basicSetPackage
    void setPackage(org.sidiff.uml.model.core.UMLPackage) -> setPackage
    org.eclipse.emf.common.notify.NotificationChain eInverseAdd(org.eclipse.emf.ecore.InternalEObject,int,org.eclipse.emf.common.notify.NotificationChain) -> eInverseAdd
    org.eclipse.emf.common.notify.NotificationChain eInverseRemove(org.eclipse.emf.ecore.InternalEObject,int,org.eclipse.emf.common.notify.NotificationChain) -> eInverseRemove
    org.eclipse.emf.common.notify.NotificationChain eBasicRemoveFromContainerFeature(org.eclipse.emf.common.notify.NotificationChain) -> eBasicRemoveFromContainerFeature
    java.lang.Object eGet(int,boolean,boolean) -> eGet
    void eSet(int,java.lang.Object) -> eSet
    void eUnset(int) -> eUnset
    boolean eIsSet(int) -> eIsSet
    int eBaseStructuralFeatureID(int,java.lang.Class) -> eBaseStructuralFeatureID
    int eDerivedStructuralFeatureID(int,java.lang.Class) -> eDerivedStructuralFeatureID
    java.lang.String toString() -> toString
org.sidiff.uml.model.classes.impl.UMLGeneralizableElementImpl -> org.sidiff.uml.model.classes.impl.UMLGeneralizableElementImpl:
    org.eclipse.emf.common.util.EList specializations -> specializations
    org.eclipse.emf.common.util.EList generalizations -> generalizations
    org.eclipse.emf.ecore.EClass eStaticClass() -> eStaticClass
    org.eclipse.emf.common.util.EList getSpecializations() -> getSpecializations
    org.eclipse.emf.common.util.EList getGeneralizations() -> getGeneralizations
    org.eclipse.emf.common.notify.NotificationChain eInverseAdd(org.eclipse.emf.ecore.InternalEObject,int,org.eclipse.emf.common.notify.NotificationChain) -> eInverseAdd
    org.eclipse.emf.common.notify.NotificationChain eInverseRemove(org.eclipse.emf.ecore.InternalEObject,int,org.eclipse.emf.common.notify.NotificationChain) -> eInverseRemove
    java.lang.Object eGet(int,boolean,boolean) -> eGet
    void eSet(int,java.lang.Object) -> eSet
    void eUnset(int) -> eUnset
    boolean eIsSet(int) -> eIsSet
org.sidiff.uml.model.classes.impl.UMLGeneralizationImpl -> org.sidiff.uml.model.classes.impl.UMLGeneralizationImpl:
    org.sidiff.uml.model.classes.UMLGeneralizableElement generalElement -> generalElement
    org.eclipse.emf.ecore.EClass eStaticClass() -> eStaticClass
    org.sidiff.uml.model.classes.UMLGeneralizableElement getSpecialElement() -> getSpecialElement
    org.eclipse.emf.common.notify.NotificationChain basicSetSpecialElement(org.sidiff.uml.model.classes.UMLGeneralizableElement,org.eclipse.emf.common.notify.NotificationChain) -> basicSetSpecialElement
    void setSpecialElement(org.sidiff.uml.model.classes.UMLGeneralizableElement) -> setSpecialElement
    org.sidiff.uml.model.classes.UMLGeneralizableElement getGeneralElement() -> getGeneralElement
    org.sidiff.uml.model.classes.UMLGeneralizableElement basicGetGeneralElement() -> basicGetGeneralElement
    org.eclipse.emf.common.notify.NotificationChain basicSetGeneralElement(org.sidiff.uml.model.classes.UMLGeneralizableElement,org.eclipse.emf.common.notify.NotificationChain) -> basicSetGeneralElement
    void setGeneralElement(org.sidiff.uml.model.classes.UMLGeneralizableElement) -> setGeneralElement
    org.eclipse.emf.common.notify.NotificationChain eInverseAdd(org.eclipse.emf.ecore.InternalEObject,int,org.eclipse.emf.common.notify.NotificationChain) -> eInverseAdd
    org.eclipse.emf.common.notify.NotificationChain eInverseRemove(org.eclipse.emf.ecore.InternalEObject,int,org.eclipse.emf.common.notify.NotificationChain) -> eInverseRemove
    org.eclipse.emf.common.notify.NotificationChain eBasicRemoveFromContainerFeature(org.eclipse.emf.common.notify.NotificationChain) -> eBasicRemoveFromContainerFeature
    java.lang.Object eGet(int,boolean,boolean) -> eGet
    void eSet(int,java.lang.Object) -> eSet
    void eUnset(int) -> eUnset
    boolean eIsSet(int) -> eIsSet
org.sidiff.uml.model.classes.impl.UMLInterfaceImpl -> org.sidiff.uml.model.classes.impl.UMLInterfaceImpl:
    org.eclipse.emf.common.util.EList operations -> operations
    org.eclipse.emf.ecore.EClass eStaticClass() -> eStaticClass
    org.eclipse.emf.common.util.EList getOperations() -> getOperations
    org.eclipse.emf.common.notify.NotificationChain eInverseAdd(org.eclipse.emf.ecore.InternalEObject,int,org.eclipse.emf.common.notify.NotificationChain) -> eInverseAdd
    org.eclipse.emf.common.notify.NotificationChain eInverseRemove(org.eclipse.emf.ecore.InternalEObject,int,org.eclipse.emf.common.notify.NotificationChain) -> eInverseRemove
    java.lang.Object eGet(int,boolean,boolean) -> eGet
    void eSet(int,java.lang.Object) -> eSet
    void eUnset(int) -> eUnset
    boolean eIsSet(int) -> eIsSet
org.sidiff.uml.model.classes.impl.UMLLiteralImpl -> org.sidiff.uml.model.classes.impl.UMLLiteralImpl:
    org.eclipse.emf.ecore.EClass eStaticClass() -> eStaticClass
    org.sidiff.uml.model.classes.UMLEnumeration getEnumeration() -> getEnumeration
    org.eclipse.emf.common.notify.NotificationChain basicSetEnumeration(org.sidiff.uml.model.classes.UMLEnumeration,org.eclipse.emf.common.notify.NotificationChain) -> basicSetEnumeration
    void setEnumeration(org.sidiff.uml.model.classes.UMLEnumeration) -> setEnumeration
    org.eclipse.emf.common.notify.NotificationChain eInverseAdd(org.eclipse.emf.ecore.InternalEObject,int,org.eclipse.emf.common.notify.NotificationChain) -> eInverseAdd
    org.eclipse.emf.common.notify.NotificationChain eInverseRemove(org.eclipse.emf.ecore.InternalEObject,int,org.eclipse.emf.common.notify.NotificationChain) -> eInverseRemove
    org.eclipse.emf.common.notify.NotificationChain eBasicRemoveFromContainerFeature(org.eclipse.emf.common.notify.NotificationChain) -> eBasicRemoveFromContainerFeature
    java.lang.Object eGet(int,boolean,boolean) -> eGet
    void eSet(int,java.lang.Object) -> eSet
    void eUnset(int) -> eUnset
    boolean eIsSet(int) -> eIsSet
org.sidiff.uml.model.classes.impl.UMLOperationImpl -> org.sidiff.uml.model.classes.impl.UMLOperationImpl:
    org.eclipse.emf.common.util.EList stereotypes -> stereotypes
    org.sidiff.uml.model.classes.UMLType type -> type
    org.sidiff.uml.model.core.UMLVisibility VISIBILITY_EDEFAULT -> VISIBILITY_EDEFAULT
    org.sidiff.uml.model.core.UMLVisibility visibility -> visibility
    boolean IS_ABSTRACT_EDEFAULT -> IS_ABSTRACT_EDEFAULT
    boolean isAbstract -> isAbstract
    boolean IS_STATIC_EDEFAULT -> IS_STATIC_EDEFAULT
    boolean isStatic -> isStatic
    org.eclipse.emf.common.util.EList parameters -> parameters
    org.eclipse.emf.ecore.EClass eStaticClass() -> eStaticClass
    org.eclipse.emf.common.util.EList getStereotypes() -> getStereotypes
    org.sidiff.uml.model.classes.UMLType getType() -> getType
    org.sidiff.uml.model.classes.UMLType basicGetType() -> basicGetType
    org.eclipse.emf.common.notify.NotificationChain basicSetType(org.sidiff.uml.model.classes.UMLType,org.eclipse.emf.common.notify.NotificationChain) -> basicSetType
    void setType(org.sidiff.uml.model.classes.UMLType) -> setType
    org.sidiff.uml.model.core.UMLVisibility getVisibility() -> getVisibility
    void setVisibility(org.sidiff.uml.model.core.UMLVisibility) -> setVisibility
    boolean isIsAbstract() -> isIsAbstract
    void setIsAbstract(boolean) -> setIsAbstract
    boolean isIsStatic() -> isIsStatic
    void setIsStatic(boolean) -> setIsStatic
    org.sidiff.uml.model.classes.UMLInterface getInterface() -> getInterface
    org.eclipse.emf.common.notify.NotificationChain basicSetInterface(org.sidiff.uml.model.classes.UMLInterface,org.eclipse.emf.common.notify.NotificationChain) -> basicSetInterface
    void setInterface(org.sidiff.uml.model.classes.UMLInterface) -> setInterface
    org.eclipse.emf.common.util.EList getParameters() -> getParameters
    org.sidiff.uml.model.classes.UMLClass getClass_() -> getClass_
    org.eclipse.emf.common.notify.NotificationChain basicSetClass(org.sidiff.uml.model.classes.UMLClass,org.eclipse.emf.common.notify.NotificationChain) -> basicSetClass
    void setClass(org.sidiff.uml.model.classes.UMLClass) -> setClass
    org.eclipse.emf.common.notify.NotificationChain eInverseAdd(org.eclipse.emf.ecore.InternalEObject,int,org.eclipse.emf.common.notify.NotificationChain) -> eInverseAdd
    org.eclipse.emf.common.notify.NotificationChain eInverseRemove(org.eclipse.emf.ecore.InternalEObject,int,org.eclipse.emf.common.notify.NotificationChain) -> eInverseRemove
    org.eclipse.emf.common.notify.NotificationChain eBasicRemoveFromContainerFeature(org.eclipse.emf.common.notify.NotificationChain) -> eBasicRemoveFromContainerFeature
    java.lang.Object eGet(int,boolean,boolean) -> eGet
    void eSet(int,java.lang.Object) -> eSet
    void eUnset(int) -> eUnset
    boolean eIsSet(int) -> eIsSet
    int eBaseStructuralFeatureID(int,java.lang.Class) -> eBaseStructuralFeatureID
    int eDerivedStructuralFeatureID(int,java.lang.Class) -> eDerivedStructuralFeatureID
    java.lang.String toString() -> toString
org.sidiff.uml.model.classes.impl.UMLParameterImpl -> org.sidiff.uml.model.classes.impl.UMLParameterImpl:
    org.eclipse.emf.common.util.EList stereotypes -> stereotypes
    org.sidiff.uml.model.classes.UMLType type -> type
    org.sidiff.uml.model.classes.UMLParameterKind KIND_EDEFAULT -> KIND_EDEFAULT
    org.sidiff.uml.model.classes.UMLParameterKind kind -> kind
    org.eclipse.emf.ecore.EClass eStaticClass() -> eStaticClass
    org.eclipse.emf.common.util.EList getStereotypes() -> getStereotypes
    org.sidiff.uml.model.classes.UMLType getType() -> getType
    org.sidiff.uml.model.classes.UMLType basicGetType() -> basicGetType
    org.eclipse.emf.common.notify.NotificationChain basicSetType(org.sidiff.uml.model.classes.UMLType,org.eclipse.emf.common.notify.NotificationChain) -> basicSetType
    void setType(org.sidiff.uml.model.classes.UMLType) -> setType
    org.sidiff.uml.model.classes.UMLParameterKind getKind() -> getKind
    void setKind(org.sidiff.uml.model.classes.UMLParameterKind) -> setKind
    org.sidiff.uml.model.classes.UMLOperation getOperation() -> getOperation
    org.eclipse.emf.common.notify.NotificationChain basicSetOperation(org.sidiff.uml.model.classes.UMLOperation,org.eclipse.emf.common.notify.NotificationChain) -> basicSetOperation
    void setOperation(org.sidiff.uml.model.classes.UMLOperation) -> setOperation
    org.eclipse.emf.common.notify.NotificationChain eInverseAdd(org.eclipse.emf.ecore.InternalEObject,int,org.eclipse.emf.common.notify.NotificationChain) -> eInverseAdd
    org.eclipse.emf.common.notify.NotificationChain eInverseRemove(org.eclipse.emf.ecore.InternalEObject,int,org.eclipse.emf.common.notify.NotificationChain) -> eInverseRemove
    org.eclipse.emf.common.notify.NotificationChain eBasicRemoveFromContainerFeature(org.eclipse.emf.common.notify.NotificationChain) -> eBasicRemoveFromContainerFeature
    java.lang.Object eGet(int,boolean,boolean) -> eGet
    void eSet(int,java.lang.Object) -> eSet
    void eUnset(int) -> eUnset
    boolean eIsSet(int) -> eIsSet
    int eBaseStructuralFeatureID(int,java.lang.Class) -> eBaseStructuralFeatureID
    int eDerivedStructuralFeatureID(int,java.lang.Class) -> eDerivedStructuralFeatureID
    java.lang.String toString() -> toString
org.sidiff.uml.model.classes.impl.UMLPrimitiveTypeImpl -> org.sidiff.uml.model.classes.impl.UMLPrimitiveTypeImpl:
    org.eclipse.emf.ecore.EClass eStaticClass() -> eStaticClass
    org.sidiff.uml.model.core.UMLPackage getPackage() -> getPackage
    org.eclipse.emf.common.notify.NotificationChain basicSetPackage(org.sidiff.uml.model.core.UMLPackage,org.eclipse.emf.common.notify.NotificationChain) -> basicSetPackage
    void setPackage(org.sidiff.uml.model.core.UMLPackage) -> setPackage
    org.eclipse.emf.common.notify.NotificationChain eInverseAdd(org.eclipse.emf.ecore.InternalEObject,int,org.eclipse.emf.common.notify.NotificationChain) -> eInverseAdd
    org.eclipse.emf.common.notify.NotificationChain eInverseRemove(org.eclipse.emf.ecore.InternalEObject,int,org.eclipse.emf.common.notify.NotificationChain) -> eInverseRemove
    org.eclipse.emf.common.notify.NotificationChain eBasicRemoveFromContainerFeature(org.eclipse.emf.common.notify.NotificationChain) -> eBasicRemoveFromContainerFeature
    java.lang.Object eGet(int,boolean,boolean) -> eGet
    void eSet(int,java.lang.Object) -> eSet
    void eUnset(int) -> eUnset
    boolean eIsSet(int) -> eIsSet
org.sidiff.uml.model.classes.impl.UMLTemplateBindingImpl -> org.sidiff.uml.model.classes.impl.UMLTemplateBindingImpl:
    org.sidiff.uml.model.classes.UMLTemplateParameter formalParam -> formalParam
    java.lang.String ACTUAL_PARAM_EDEFAULT -> ACTUAL_PARAM_EDEFAULT
    java.lang.String actualParam -> actualParam
    org.eclipse.emf.ecore.EClass eStaticClass() -> eStaticClass
    org.sidiff.uml.model.classes.UMLTemplateParameter getFormalParam() -> getFormalParam
    org.sidiff.uml.model.classes.UMLTemplateParameter basicGetFormalParam() -> basicGetFormalParam
    org.eclipse.emf.common.notify.NotificationChain basicSetFormalParam(org.sidiff.uml.model.classes.UMLTemplateParameter,org.eclipse.emf.common.notify.NotificationChain) -> basicSetFormalParam
    void setFormalParam(org.sidiff.uml.model.classes.UMLTemplateParameter) -> setFormalParam
    java.lang.String getActualParam() -> getActualParam
    void setActualParam(java.lang.String) -> setActualParam
    org.sidiff.uml.model.classes.UMLBindingElement getBinder() -> getBinder
    org.eclipse.emf.common.notify.NotificationChain basicSetBinder(org.sidiff.uml.model.classes.UMLBindingElement,org.eclipse.emf.common.notify.NotificationChain) -> basicSetBinder
    void setBinder(org.sidiff.uml.model.classes.UMLBindingElement) -> setBinder
    org.eclipse.emf.common.notify.NotificationChain eInverseAdd(org.eclipse.emf.ecore.InternalEObject,int,org.eclipse.emf.common.notify.NotificationChain) -> eInverseAdd
    org.eclipse.emf.common.notify.NotificationChain eInverseRemove(org.eclipse.emf.ecore.InternalEObject,int,org.eclipse.emf.common.notify.NotificationChain) -> eInverseRemove
    org.eclipse.emf.common.notify.NotificationChain eBasicRemoveFromContainerFeature(org.eclipse.emf.common.notify.NotificationChain) -> eBasicRemoveFromContainerFeature
    java.lang.Object eGet(int,boolean,boolean) -> eGet
    void eSet(int,java.lang.Object) -> eSet
    void eUnset(int) -> eUnset
    boolean eIsSet(int) -> eIsSet
    java.lang.String toString() -> toString
org.sidiff.uml.model.classes.impl.UMLTemplateParameterImpl -> org.sidiff.uml.model.classes.impl.UMLTemplateParameterImpl:
    java.lang.String TYPE_EDEFAULT -> TYPE_EDEFAULT
    java.lang.String type -> type
    org.eclipse.emf.common.util.EList bindings -> bindings
    org.eclipse.emf.ecore.EClass eStaticClass() -> eStaticClass
    org.sidiff.uml.model.classes.UMLTemplateableElement getTemplateableElement() -> getTemplateableElement
    org.eclipse.emf.common.notify.NotificationChain basicSetTemplateableElement(org.sidiff.uml.model.classes.UMLTemplateableElement,org.eclipse.emf.common.notify.NotificationChain) -> basicSetTemplateableElement
    void setTemplateableElement(org.sidiff.uml.model.classes.UMLTemplateableElement) -> setTemplateableElement
    java.lang.String getType() -> getType
    void setType(java.lang.String) -> setType
    org.eclipse.emf.common.util.EList getBindings() -> getBindings
    org.eclipse.emf.common.notify.NotificationChain eInverseAdd(org.eclipse.emf.ecore.InternalEObject,int,org.eclipse.emf.common.notify.NotificationChain) -> eInverseAdd
    org.eclipse.emf.common.notify.NotificationChain eInverseRemove(org.eclipse.emf.ecore.InternalEObject,int,org.eclipse.emf.common.notify.NotificationChain) -> eInverseRemove
    org.eclipse.emf.common.notify.NotificationChain eBasicRemoveFromContainerFeature(org.eclipse.emf.common.notify.NotificationChain) -> eBasicRemoveFromContainerFeature
    java.lang.Object eGet(int,boolean,boolean) -> eGet
    void eSet(int,java.lang.Object) -> eSet
    void eUnset(int) -> eUnset
    boolean eIsSet(int) -> eIsSet
    java.lang.String toString() -> toString
org.sidiff.uml.model.classes.impl.UMLTemplateableElementImpl -> org.sidiff.uml.model.classes.impl.UMLTemplateableElementImpl:
    org.eclipse.emf.common.util.EList templateParameters -> templateParameters
    org.eclipse.emf.ecore.EClass eStaticClass() -> eStaticClass
    org.eclipse.emf.common.util.EList getTemplateParameters() -> getTemplateParameters
    org.eclipse.emf.common.notify.NotificationChain eInverseAdd(org.eclipse.emf.ecore.InternalEObject,int,org.eclipse.emf.common.notify.NotificationChain) -> eInverseAdd
    org.eclipse.emf.common.notify.NotificationChain eInverseRemove(org.eclipse.emf.ecore.InternalEObject,int,org.eclipse.emf.common.notify.NotificationChain) -> eInverseRemove
    java.lang.Object eGet(int,boolean,boolean) -> eGet
    void eSet(int,java.lang.Object) -> eSet
    void eUnset(int) -> eUnset
    boolean eIsSet(int) -> eIsSet
org.sidiff.uml.model.classes.impl.UMLTypeImpl -> org.sidiff.uml.model.classes.impl.UMLTypeImpl:
    org.eclipse.emf.common.util.EList usedByElements -> usedByElements
    org.eclipse.emf.ecore.EClass eStaticClass() -> eStaticClass
    org.eclipse.emf.common.util.EList getUsedByElements() -> getUsedByElements
    org.eclipse.emf.common.notify.NotificationChain eInverseAdd(org.eclipse.emf.ecore.InternalEObject,int,org.eclipse.emf.common.notify.NotificationChain) -> eInverseAdd
    org.eclipse.emf.common.notify.NotificationChain eInverseRemove(org.eclipse.emf.ecore.InternalEObject,int,org.eclipse.emf.common.notify.NotificationChain) -> eInverseRemove
    java.lang.Object eGet(int,boolean,boolean) -> eGet
    void eSet(int,java.lang.Object) -> eSet
    void eUnset(int) -> eUnset
    boolean eIsSet(int) -> eIsSet
org.sidiff.uml.model.classes.impl.UMLTypedElementImpl -> org.sidiff.uml.model.classes.impl.UMLTypedElementImpl:
    org.sidiff.uml.model.classes.UMLType type -> type
    org.eclipse.emf.ecore.EClass eStaticClass() -> eStaticClass
    org.sidiff.uml.model.classes.UMLType getType() -> getType
    org.sidiff.uml.model.classes.UMLType basicGetType() -> basicGetType
    org.eclipse.emf.common.notify.NotificationChain basicSetType(org.sidiff.uml.model.classes.UMLType,org.eclipse.emf.common.notify.NotificationChain) -> basicSetType
    void setType(org.sidiff.uml.model.classes.UMLType) -> setType
    org.eclipse.emf.common.notify.NotificationChain eInverseAdd(org.eclipse.emf.ecore.InternalEObject,int,org.eclipse.emf.common.notify.NotificationChain) -> eInverseAdd
    org.eclipse.emf.common.notify.NotificationChain eInverseRemove(org.eclipse.emf.ecore.InternalEObject,int,org.eclipse.emf.common.notify.NotificationChain) -> eInverseRemove
    java.lang.Object eGet(int,boolean,boolean) -> eGet
    void eSet(int,java.lang.Object) -> eSet
    void eUnset(int) -> eUnset
    boolean eIsSet(int) -> eIsSet
org.sidiff.uml.model.classes.util.ClassesAdapterFactory -> org.sidiff.uml.model.classes.util.ClassesAdapterFactory:
    org.sidiff.uml.model.classes.ClassesPackage modelPackage -> modelPackage
    org.sidiff.uml.model.classes.util.ClassesSwitch modelSwitch -> modelSwitch
    boolean isFactoryForType(java.lang.Object) -> isFactoryForType
    org.eclipse.emf.common.notify.Adapter createAdapter(org.eclipse.emf.common.notify.Notifier) -> createAdapter
    org.eclipse.emf.common.notify.Adapter createUMLAssociationAdapter() -> createUMLAssociationAdapter
    org.eclipse.emf.common.notify.Adapter createUMLClassifierAdapter() -> createUMLClassifierAdapter
    org.eclipse.emf.common.notify.Adapter createUMLTypeAdapter() -> createUMLTypeAdapter
    org.eclipse.emf.common.notify.Adapter createUMLTypedElementAdapter() -> createUMLTypedElementAdapter
    org.eclipse.emf.common.notify.Adapter createUMLGeneralizableElementAdapter() -> createUMLGeneralizableElementAdapter
    org.eclipse.emf.common.notify.Adapter createUMLGeneralizationAdapter() -> createUMLGeneralizationAdapter
    org.eclipse.emf.common.notify.Adapter createUMLBindingElementAdapter() -> createUMLBindingElementAdapter
    org.eclipse.emf.common.notify.Adapter createUMLTemplateBindingAdapter() -> createUMLTemplateBindingAdapter
    org.eclipse.emf.common.notify.Adapter createUMLTemplateParameterAdapter() -> createUMLTemplateParameterAdapter
    org.eclipse.emf.common.notify.Adapter createUMLTemplateableElementAdapter() -> createUMLTemplateableElementAdapter
    org.eclipse.emf.common.notify.Adapter createUMLAssociationEndAdapter() -> createUMLAssociationEndAdapter
    org.eclipse.emf.common.notify.Adapter createUMLEnumerationAdapter() -> createUMLEnumerationAdapter
    org.eclipse.emf.common.notify.Adapter createUMLLiteralAdapter() -> createUMLLiteralAdapter
    org.eclipse.emf.common.notify.Adapter createUMLPrimitiveTypeAdapter() -> createUMLPrimitiveTypeAdapter
    org.eclipse.emf.common.notify.Adapter createUMLAssociationClassAdapter() -> createUMLAssociationClassAdapter
    org.eclipse.emf.common.notify.Adapter createUMLClassAdapter() -> createUMLClassAdapter
    org.eclipse.emf.common.notify.Adapter createUMLOperationAdapter() -> createUMLOperationAdapter
    org.eclipse.emf.common.notify.Adapter createUMLInterfaceAdapter() -> createUMLInterfaceAdapter
    org.eclipse.emf.common.notify.Adapter createUMLParameterAdapter() -> createUMLParameterAdapter
    org.eclipse.emf.common.notify.Adapter createUMLAttributeAdapter() -> createUMLAttributeAdapter
    org.eclipse.emf.common.notify.Adapter createUMLElementAdapter() -> createUMLElementAdapter
    org.eclipse.emf.common.notify.Adapter createUMLNamedElementAdapter() -> createUMLNamedElementAdapter
    org.eclipse.emf.common.notify.Adapter createUMLStereotypeableElementAdapter() -> createUMLStereotypeableElementAdapter
    org.eclipse.emf.common.notify.Adapter createUMLVisibleElementAdapter() -> createUMLVisibleElementAdapter
    org.eclipse.emf.common.notify.Adapter createEObjectAdapter() -> createEObjectAdapter
org.sidiff.uml.model.classes.util.ClassesAdapterFactory$1 -> org.sidiff.uml.model.classes.util.ClassesAdapterFactory$1:
    org.sidiff.uml.model.classes.util.ClassesAdapterFactory this$0 -> this$0
    org.eclipse.emf.common.notify.Adapter caseUMLAssociation(org.sidiff.uml.model.classes.UMLAssociation) -> caseUMLAssociation
    org.eclipse.emf.common.notify.Adapter caseUMLClassifier(org.sidiff.uml.model.classes.UMLClassifier) -> caseUMLClassifier
    org.eclipse.emf.common.notify.Adapter caseUMLType(org.sidiff.uml.model.classes.UMLType) -> caseUMLType
    org.eclipse.emf.common.notify.Adapter caseUMLTypedElement(org.sidiff.uml.model.classes.UMLTypedElement) -> caseUMLTypedElement
    org.eclipse.emf.common.notify.Adapter caseUMLGeneralizableElement(org.sidiff.uml.model.classes.UMLGeneralizableElement) -> caseUMLGeneralizableElement
    org.eclipse.emf.common.notify.Adapter caseUMLGeneralization(org.sidiff.uml.model.classes.UMLGeneralization) -> caseUMLGeneralization
    org.eclipse.emf.common.notify.Adapter caseUMLBindingElement(org.sidiff.uml.model.classes.UMLBindingElement) -> caseUMLBindingElement
    org.eclipse.emf.common.notify.Adapter caseUMLTemplateBinding(org.sidiff.uml.model.classes.UMLTemplateBinding) -> caseUMLTemplateBinding
    org.eclipse.emf.common.notify.Adapter caseUMLTemplateParameter(org.sidiff.uml.model.classes.UMLTemplateParameter) -> caseUMLTemplateParameter
    org.eclipse.emf.common.notify.Adapter caseUMLTemplateableElement(org.sidiff.uml.model.classes.UMLTemplateableElement) -> caseUMLTemplateableElement
    org.eclipse.emf.common.notify.Adapter caseUMLAssociationEnd(org.sidiff.uml.model.classes.UMLAssociationEnd) -> caseUMLAssociationEnd
    org.eclipse.emf.common.notify.Adapter caseUMLEnumeration(org.sidiff.uml.model.classes.UMLEnumeration) -> caseUMLEnumeration
    org.eclipse.emf.common.notify.Adapter caseUMLLiteral(org.sidiff.uml.model.classes.UMLLiteral) -> caseUMLLiteral
    org.eclipse.emf.common.notify.Adapter caseUMLPrimitiveType(org.sidiff.uml.model.classes.UMLPrimitiveType) -> caseUMLPrimitiveType
    org.eclipse.emf.common.notify.Adapter caseUMLAssociationClass(org.sidiff.uml.model.classes.UMLAssociationClass) -> caseUMLAssociationClass
    org.eclipse.emf.common.notify.Adapter caseUMLClass(org.sidiff.uml.model.classes.UMLClass) -> caseUMLClass
    org.eclipse.emf.common.notify.Adapter caseUMLOperation(org.sidiff.uml.model.classes.UMLOperation) -> caseUMLOperation
    org.eclipse.emf.common.notify.Adapter caseUMLInterface(org.sidiff.uml.model.classes.UMLInterface) -> caseUMLInterface
    org.eclipse.emf.common.notify.Adapter caseUMLParameter(org.sidiff.uml.model.classes.UMLParameter) -> caseUMLParameter
    org.eclipse.emf.common.notify.Adapter caseUMLAttribute(org.sidiff.uml.model.classes.UMLAttribute) -> caseUMLAttribute
    org.eclipse.emf.common.notify.Adapter caseUMLElement(org.sidiff.uml.model.core.UMLElement) -> caseUMLElement
    org.eclipse.emf.common.notify.Adapter caseUMLNamedElement(org.sidiff.uml.model.core.UMLNamedElement) -> caseUMLNamedElement
    org.eclipse.emf.common.notify.Adapter caseUMLStereotypeableElement(org.sidiff.uml.model.core.UMLStereotypeableElement) -> caseUMLStereotypeableElement
    org.eclipse.emf.common.notify.Adapter caseUMLVisibleElement(org.sidiff.uml.model.core.UMLVisibleElement) -> caseUMLVisibleElement
    org.eclipse.emf.common.notify.Adapter defaultCase(org.eclipse.emf.ecore.EObject) -> defaultCase
    java.lang.Object caseUMLLiteral(org.sidiff.uml.model.classes.UMLLiteral) -> caseUMLLiteral
    java.lang.Object caseUMLAssociationEnd(org.sidiff.uml.model.classes.UMLAssociationEnd) -> caseUMLAssociationEnd
    java.lang.Object caseUMLTemplateBinding(org.sidiff.uml.model.classes.UMLTemplateBinding) -> caseUMLTemplateBinding
    java.lang.Object caseUMLTypedElement(org.sidiff.uml.model.classes.UMLTypedElement) -> caseUMLTypedElement
    java.lang.Object caseUMLGeneralization(org.sidiff.uml.model.classes.UMLGeneralization) -> caseUMLGeneralization
    java.lang.Object caseUMLNamedElement(org.sidiff.uml.model.core.UMLNamedElement) -> caseUMLNamedElement
    java.lang.Object caseUMLTemplateParameter(org.sidiff.uml.model.classes.UMLTemplateParameter) -> caseUMLTemplateParameter
    java.lang.Object caseUMLStereotypeableElement(org.sidiff.uml.model.core.UMLStereotypeableElement) -> caseUMLStereotypeableElement
    java.lang.Object caseUMLBindingElement(org.sidiff.uml.model.classes.UMLBindingElement) -> caseUMLBindingElement
    java.lang.Object caseUMLElement(org.sidiff.uml.model.core.UMLElement) -> caseUMLElement
    java.lang.Object defaultCase(org.eclipse.emf.ecore.EObject) -> defaultCase
    java.lang.Object caseUMLAssociationClass(org.sidiff.uml.model.classes.UMLAssociationClass) -> caseUMLAssociationClass
    java.lang.Object caseUMLClassifier(org.sidiff.uml.model.classes.UMLClassifier) -> caseUMLClassifier
    java.lang.Object caseUMLType(org.sidiff.uml.model.classes.UMLType) -> caseUMLType
    java.lang.Object caseUMLInterface(org.sidiff.uml.model.classes.UMLInterface) -> caseUMLInterface
    java.lang.Object caseUMLAssociation(org.sidiff.uml.model.classes.UMLAssociation) -> caseUMLAssociation
    java.lang.Object caseUMLEnumeration(org.sidiff.uml.model.classes.UMLEnumeration) -> caseUMLEnumeration
    java.lang.Object caseUMLAttribute(org.sidiff.uml.model.classes.UMLAttribute) -> caseUMLAttribute
    java.lang.Object caseUMLVisibleElement(org.sidiff.uml.model.core.UMLVisibleElement) -> caseUMLVisibleElement
    java.lang.Object caseUMLOperation(org.sidiff.uml.model.classes.UMLOperation) -> caseUMLOperation
    java.lang.Object caseUMLPrimitiveType(org.sidiff.uml.model.classes.UMLPrimitiveType) -> caseUMLPrimitiveType
    java.lang.Object caseUMLGeneralizableElement(org.sidiff.uml.model.classes.UMLGeneralizableElement) -> caseUMLGeneralizableElement
    java.lang.Object caseUMLClass(org.sidiff.uml.model.classes.UMLClass) -> caseUMLClass
    java.lang.Object caseUMLParameter(org.sidiff.uml.model.classes.UMLParameter) -> caseUMLParameter
    java.lang.Object caseUMLTemplateableElement(org.sidiff.uml.model.classes.UMLTemplateableElement) -> caseUMLTemplateableElement
org.sidiff.uml.model.classes.util.ClassesSwitch -> org.sidiff.uml.model.classes.util.ClassesSwitch:
    org.sidiff.uml.model.classes.ClassesPackage modelPackage -> modelPackage
    java.lang.Object doSwitch(org.eclipse.emf.ecore.EObject) -> doSwitch
    java.lang.Object doSwitch(org.eclipse.emf.ecore.EClass,org.eclipse.emf.ecore.EObject) -> doSwitch
    java.lang.Object doSwitch(int,org.eclipse.emf.ecore.EObject) -> doSwitch
    java.lang.Object caseUMLAssociation(org.sidiff.uml.model.classes.UMLAssociation) -> caseUMLAssociation
    java.lang.Object caseUMLClassifier(org.sidiff.uml.model.classes.UMLClassifier) -> caseUMLClassifier
    java.lang.Object caseUMLType(org.sidiff.uml.model.classes.UMLType) -> caseUMLType
    java.lang.Object caseUMLTypedElement(org.sidiff.uml.model.classes.UMLTypedElement) -> caseUMLTypedElement
    java.lang.Object caseUMLGeneralizableElement(org.sidiff.uml.model.classes.UMLGeneralizableElement) -> caseUMLGeneralizableElement
    java.lang.Object caseUMLGeneralization(org.sidiff.uml.model.classes.UMLGeneralization) -> caseUMLGeneralization
    java.lang.Object caseUMLBindingElement(org.sidiff.uml.model.classes.UMLBindingElement) -> caseUMLBindingElement
    java.lang.Object caseUMLTemplateBinding(org.sidiff.uml.model.classes.UMLTemplateBinding) -> caseUMLTemplateBinding
    java.lang.Object caseUMLTemplateParameter(org.sidiff.uml.model.classes.UMLTemplateParameter) -> caseUMLTemplateParameter
    java.lang.Object caseUMLTemplateableElement(org.sidiff.uml.model.classes.UMLTemplateableElement) -> caseUMLTemplateableElement
    java.lang.Object caseUMLAssociationEnd(org.sidiff.uml.model.classes.UMLAssociationEnd) -> caseUMLAssociationEnd
    java.lang.Object caseUMLEnumeration(org.sidiff.uml.model.classes.UMLEnumeration) -> caseUMLEnumeration
    java.lang.Object caseUMLLiteral(org.sidiff.uml.model.classes.UMLLiteral) -> caseUMLLiteral
    java.lang.Object caseUMLPrimitiveType(org.sidiff.uml.model.classes.UMLPrimitiveType) -> caseUMLPrimitiveType
    java.lang.Object caseUMLAssociationClass(org.sidiff.uml.model.classes.UMLAssociationClass) -> caseUMLAssociationClass
    java.lang.Object caseUMLClass(org.sidiff.uml.model.classes.UMLClass) -> caseUMLClass
    java.lang.Object caseUMLOperation(org.sidiff.uml.model.classes.UMLOperation) -> caseUMLOperation
    java.lang.Object caseUMLInterface(org.sidiff.uml.model.classes.UMLInterface) -> caseUMLInterface
    java.lang.Object caseUMLParameter(org.sidiff.uml.model.classes.UMLParameter) -> caseUMLParameter
    java.lang.Object caseUMLAttribute(org.sidiff.uml.model.classes.UMLAttribute) -> caseUMLAttribute
    java.lang.Object caseUMLElement(org.sidiff.uml.model.core.UMLElement) -> caseUMLElement
    java.lang.Object caseUMLNamedElement(org.sidiff.uml.model.core.UMLNamedElement) -> caseUMLNamedElement
    java.lang.Object caseUMLStereotypeableElement(org.sidiff.uml.model.core.UMLStereotypeableElement) -> caseUMLStereotypeableElement
    java.lang.Object caseUMLVisibleElement(org.sidiff.uml.model.core.UMLVisibleElement) -> caseUMLVisibleElement
    java.lang.Object defaultCase(org.eclipse.emf.ecore.EObject) -> defaultCase
org.sidiff.uml.model.core.CoreFactory -> org.sidiff.uml.model.core.CoreFactory:
    org.sidiff.uml.model.core.CoreFactory eINSTANCE -> eINSTANCE
    org.sidiff.uml.model.core.UMLPackage createUMLPackage() -> createUMLPackage
    org.sidiff.uml.model.core.UMLStereotypeableElement createUMLStereotypeableElement() -> createUMLStereotypeableElement
    org.sidiff.uml.model.core.UMLStereotype createUMLStereotype() -> createUMLStereotype
    org.sidiff.uml.model.core.UMLModel createUMLModel() -> createUMLModel
    org.sidiff.uml.model.core.UMLComment createUMLComment() -> createUMLComment
    org.sidiff.uml.model.core.UMLDependency createUMLDependency() -> createUMLDependency
    org.sidiff.uml.model.core.CorePackage getCorePackage() -> getCorePackage
org.sidiff.uml.model.core.CorePackage -> org.sidiff.uml.model.core.CorePackage:
    java.lang.String eNAME -> eNAME
    java.lang.String eNS_URI -> eNS_URI
    java.lang.String eNS_PREFIX -> eNS_PREFIX
    org.sidiff.uml.model.core.CorePackage eINSTANCE -> eINSTANCE
    int UML_VISIBLE_ELEMENT -> UML_VISIBLE_ELEMENT
    int UML_VISIBLE_ELEMENT__VISIBILITY -> UML_VISIBLE_ELEMENT__VISIBILITY
    int UML_VISIBLE_ELEMENT_FEATURE_COUNT -> UML_VISIBLE_ELEMENT_FEATURE_COUNT
    int UML_ELEMENT -> UML_ELEMENT
    int UML_ELEMENT__ID -> UML_ELEMENT__ID
    int UML_ELEMENT__COMMENTS -> UML_ELEMENT__COMMENTS
    int UML_ELEMENT_FEATURE_COUNT -> UML_ELEMENT_FEATURE_COUNT
    int UML_NAMED_ELEMENT -> UML_NAMED_ELEMENT
    int UML_NAMED_ELEMENT__ID -> UML_NAMED_ELEMENT__ID
    int UML_NAMED_ELEMENT__COMMENTS -> UML_NAMED_ELEMENT__COMMENTS
    int UML_NAMED_ELEMENT__OUTGOING_DEPENDENCIES -> UML_NAMED_ELEMENT__OUTGOING_DEPENDENCIES
    int UML_NAMED_ELEMENT__DEPENDEES -> UML_NAMED_ELEMENT__DEPENDEES
    int UML_NAMED_ELEMENT__NAME -> UML_NAMED_ELEMENT__NAME
    int UML_NAMED_ELEMENT_FEATURE_COUNT -> UML_NAMED_ELEMENT_FEATURE_COUNT
    int UML_PACKAGE -> UML_PACKAGE
    int UML_PACKAGE__ID -> UML_PACKAGE__ID
    int UML_PACKAGE__COMMENTS -> UML_PACKAGE__COMMENTS
    int UML_PACKAGE__OUTGOING_DEPENDENCIES -> UML_PACKAGE__OUTGOING_DEPENDENCIES
    int UML_PACKAGE__DEPENDEES -> UML_PACKAGE__DEPENDEES
    int UML_PACKAGE__NAME -> UML_PACKAGE__NAME
    int UML_PACKAGE__STEREOTYPES -> UML_PACKAGE__STEREOTYPES
    int UML_PACKAGE__VISIBILITY -> UML_PACKAGE__VISIBILITY
    int UML_PACKAGE__MODEL -> UML_PACKAGE__MODEL
    int UML_PACKAGE__PACKAGES -> UML_PACKAGE__PACKAGES
    int UML_PACKAGE__SUPER_PACKAGE -> UML_PACKAGE__SUPER_PACKAGE
    int UML_PACKAGE__CLASSIFIERS -> UML_PACKAGE__CLASSIFIERS
    int UML_PACKAGE__STORED_COMMENTS -> UML_PACKAGE__STORED_COMMENTS
    int UML_PACKAGE__ASSOCIATIONS -> UML_PACKAGE__ASSOCIATIONS
    int UML_PACKAGE__ENUMERATIONS -> UML_PACKAGE__ENUMERATIONS
    int UML_PACKAGE__PRIMITIVE_TYPES -> UML_PACKAGE__PRIMITIVE_TYPES
    int UML_PACKAGE_FEATURE_COUNT -> UML_PACKAGE_FEATURE_COUNT
    int UML_STEREOTYPEABLE_ELEMENT -> UML_STEREOTYPEABLE_ELEMENT
    int UML_STEREOTYPEABLE_ELEMENT__STEREOTYPES -> UML_STEREOTYPEABLE_ELEMENT__STEREOTYPES
    int UML_STEREOTYPEABLE_ELEMENT_FEATURE_COUNT -> UML_STEREOTYPEABLE_ELEMENT_FEATURE_COUNT
    int UML_STEREOTYPE -> UML_STEREOTYPE
    int UML_STEREOTYPE__ID -> UML_STEREOTYPE__ID
    int UML_STEREOTYPE__COMMENTS -> UML_STEREOTYPE__COMMENTS
    int UML_STEREOTYPE__OUTGOING_DEPENDENCIES -> UML_STEREOTYPE__OUTGOING_DEPENDENCIES
    int UML_STEREOTYPE__DEPENDEES -> UML_STEREOTYPE__DEPENDEES
    int UML_STEREOTYPE__NAME -> UML_STEREOTYPE__NAME
    int UML_STEREOTYPE__MODEL -> UML_STEREOTYPE__MODEL
    int UML_STEREOTYPE__STEREOTYPED_ELEMENTS -> UML_STEREOTYPE__STEREOTYPED_ELEMENTS
    int UML_STEREOTYPE_FEATURE_COUNT -> UML_STEREOTYPE_FEATURE_COUNT
    int UML_MODEL -> UML_MODEL
    int UML_MODEL__ID -> UML_MODEL__ID
    int UML_MODEL__COMMENTS -> UML_MODEL__COMMENTS
    int UML_MODEL__OUTGOING_DEPENDENCIES -> UML_MODEL__OUTGOING_DEPENDENCIES
    int UML_MODEL__DEPENDEES -> UML_MODEL__DEPENDEES
    int UML_MODEL__NAME -> UML_MODEL__NAME
    int UML_MODEL__PACKAGES -> UML_MODEL__PACKAGES
    int UML_MODEL__STEREOTYPES -> UML_MODEL__STEREOTYPES
    int UML_MODEL_FEATURE_COUNT -> UML_MODEL_FEATURE_COUNT
    int UML_COMMENT -> UML_COMMENT
    int UML_COMMENT__PACKAGE -> UML_COMMENT__PACKAGE
    int UML_COMMENT__COMMENT -> UML_COMMENT__COMMENT
    int UML_COMMENT__ELEMENTS -> UML_COMMENT__ELEMENTS
    int UML_COMMENT_FEATURE_COUNT -> UML_COMMENT_FEATURE_COUNT
    int UML_DEPENDENCY -> UML_DEPENDENCY
    int UML_DEPENDENCY__ID -> UML_DEPENDENCY__ID
    int UML_DEPENDENCY__COMMENTS -> UML_DEPENDENCY__COMMENTS
    int UML_DEPENDENCY__OUTGOING_DEPENDENCIES -> UML_DEPENDENCY__OUTGOING_DEPENDENCIES
    int UML_DEPENDENCY__DEPENDEES -> UML_DEPENDENCY__DEPENDEES
    int UML_DEPENDENCY__NAME -> UML_DEPENDENCY__NAME
    int UML_DEPENDENCY__STEREOTYPES -> UML_DEPENDENCY__STEREOTYPES
    int UML_DEPENDENCY__DEPENDEE -> UML_DEPENDENCY__DEPENDEE
    int UML_DEPENDENCY__SUPPLIER -> UML_DEPENDENCY__SUPPLIER
    int UML_DEPENDENCY_FEATURE_COUNT -> UML_DEPENDENCY_FEATURE_COUNT
    int UML_VISIBILITY -> UML_VISIBILITY
    org.eclipse.emf.ecore.EClass getUMLVisibleElement() -> getUMLVisibleElement
    org.eclipse.emf.ecore.EAttribute getUMLVisibleElement_Visibility() -> getUMLVisibleElement_Visibility
    org.eclipse.emf.ecore.EClass getUMLPackage() -> getUMLPackage
    org.eclipse.emf.ecore.EReference getUMLPackage_Model() -> getUMLPackage_Model
    org.eclipse.emf.ecore.EReference getUMLPackage_Packages() -> getUMLPackage_Packages
    org.eclipse.emf.ecore.EReference getUMLPackage_SuperPackage() -> getUMLPackage_SuperPackage
    org.eclipse.emf.ecore.EReference getUMLPackage_Classifiers() -> getUMLPackage_Classifiers
    org.eclipse.emf.ecore.EReference getUMLPackage_StoredComments() -> getUMLPackage_StoredComments
    org.eclipse.emf.ecore.EReference getUMLPackage_Associations() -> getUMLPackage_Associations
    org.eclipse.emf.ecore.EReference getUMLPackage_Enumerations() -> getUMLPackage_Enumerations
    org.eclipse.emf.ecore.EReference getUMLPackage_PrimitiveTypes() -> getUMLPackage_PrimitiveTypes
    org.eclipse.emf.ecore.EClass getUMLStereotypeableElement() -> getUMLStereotypeableElement
    org.eclipse.emf.ecore.EReference getUMLStereotypeableElement_Stereotypes() -> getUMLStereotypeableElement_Stereotypes
    org.eclipse.emf.ecore.EClass getUMLStereotype() -> getUMLStereotype
    org.eclipse.emf.ecore.EReference getUMLStereotype_Model() -> getUMLStereotype_Model
    org.eclipse.emf.ecore.EReference getUMLStereotype_StereotypedElements() -> getUMLStereotype_StereotypedElements
    org.eclipse.emf.ecore.EClass getUMLModel() -> getUMLModel
    org.eclipse.emf.ecore.EReference getUMLModel_Packages() -> getUMLModel_Packages
    org.eclipse.emf.ecore.EReference getUMLModel_Stereotypes() -> getUMLModel_Stereotypes
    org.eclipse.emf.ecore.EClass getUMLElement() -> getUMLElement
    org.eclipse.emf.ecore.EAttribute getUMLElement_Id() -> getUMLElement_Id
    org.eclipse.emf.ecore.EReference getUMLElement_Comments() -> getUMLElement_Comments
    org.eclipse.emf.ecore.EClass getUMLComment() -> getUMLComment
    org.eclipse.emf.ecore.EReference getUMLComment_Package() -> getUMLComment_Package
    org.eclipse.emf.ecore.EAttribute getUMLComment_Comment() -> getUMLComment_Comment
    org.eclipse.emf.ecore.EReference getUMLComment_Elements() -> getUMLComment_Elements
    org.eclipse.emf.ecore.EClass getUMLDependency() -> getUMLDependency
    org.eclipse.emf.ecore.EReference getUMLDependency_Dependee() -> getUMLDependency_Dependee
    org.eclipse.emf.ecore.EReference getUMLDependency_Supplier() -> getUMLDependency_Supplier
    org.eclipse.emf.ecore.EClass getUMLNamedElement() -> getUMLNamedElement
    org.eclipse.emf.ecore.EReference getUMLNamedElement_OutgoingDependencies() -> getUMLNamedElement_OutgoingDependencies
    org.eclipse.emf.ecore.EReference getUMLNamedElement_Dependees() -> getUMLNamedElement_Dependees
    org.eclipse.emf.ecore.EAttribute getUMLNamedElement_Name() -> getUMLNamedElement_Name
    org.eclipse.emf.ecore.EEnum getUMLVisibility() -> getUMLVisibility
    org.sidiff.uml.model.core.CoreFactory getCoreFactory() -> getCoreFactory
org.sidiff.uml.model.core.CorePackage$Literals -> org.sidiff.uml.model.core.CorePackage$Literals:
    org.eclipse.emf.ecore.EClass UML_VISIBLE_ELEMENT -> UML_VISIBLE_ELEMENT
    org.eclipse.emf.ecore.EAttribute UML_VISIBLE_ELEMENT__VISIBILITY -> UML_VISIBLE_ELEMENT__VISIBILITY
    org.eclipse.emf.ecore.EClass UML_PACKAGE -> UML_PACKAGE
    org.eclipse.emf.ecore.EReference UML_PACKAGE__MODEL -> UML_PACKAGE__MODEL
    org.eclipse.emf.ecore.EReference UML_PACKAGE__PACKAGES -> UML_PACKAGE__PACKAGES
    org.eclipse.emf.ecore.EReference UML_PACKAGE__SUPER_PACKAGE -> UML_PACKAGE__SUPER_PACKAGE
    org.eclipse.emf.ecore.EReference UML_PACKAGE__CLASSIFIERS -> UML_PACKAGE__CLASSIFIERS
    org.eclipse.emf.ecore.EReference UML_PACKAGE__STORED_COMMENTS -> UML_PACKAGE__STORED_COMMENTS
    org.eclipse.emf.ecore.EReference UML_PACKAGE__ASSOCIATIONS -> UML_PACKAGE__ASSOCIATIONS
    org.eclipse.emf.ecore.EReference UML_PACKAGE__ENUMERATIONS -> UML_PACKAGE__ENUMERATIONS
    org.eclipse.emf.ecore.EReference UML_PACKAGE__PRIMITIVE_TYPES -> UML_PACKAGE__PRIMITIVE_TYPES
    org.eclipse.emf.ecore.EClass UML_STEREOTYPEABLE_ELEMENT -> UML_STEREOTYPEABLE_ELEMENT
    org.eclipse.emf.ecore.EReference UML_STEREOTYPEABLE_ELEMENT__STEREOTYPES -> UML_STEREOTYPEABLE_ELEMENT__STEREOTYPES
    org.eclipse.emf.ecore.EClass UML_STEREOTYPE -> UML_STEREOTYPE
    org.eclipse.emf.ecore.EReference UML_STEREOTYPE__MODEL -> UML_STEREOTYPE__MODEL
    org.eclipse.emf.ecore.EReference UML_STEREOTYPE__STEREOTYPED_ELEMENTS -> UML_STEREOTYPE__STEREOTYPED_ELEMENTS
    org.eclipse.emf.ecore.EClass UML_MODEL -> UML_MODEL
    org.eclipse.emf.ecore.EReference UML_MODEL__PACKAGES -> UML_MODEL__PACKAGES
    org.eclipse.emf.ecore.EReference UML_MODEL__STEREOTYPES -> UML_MODEL__STEREOTYPES
    org.eclipse.emf.ecore.EClass UML_ELEMENT -> UML_ELEMENT
    org.eclipse.emf.ecore.EAttribute UML_ELEMENT__ID -> UML_ELEMENT__ID
    org.eclipse.emf.ecore.EReference UML_ELEMENT__COMMENTS -> UML_ELEMENT__COMMENTS
    org.eclipse.emf.ecore.EClass UML_COMMENT -> UML_COMMENT
    org.eclipse.emf.ecore.EReference UML_COMMENT__PACKAGE -> UML_COMMENT__PACKAGE
    org.eclipse.emf.ecore.EAttribute UML_COMMENT__COMMENT -> UML_COMMENT__COMMENT
    org.eclipse.emf.ecore.EReference UML_COMMENT__ELEMENTS -> UML_COMMENT__ELEMENTS
    org.eclipse.emf.ecore.EClass UML_DEPENDENCY -> UML_DEPENDENCY
    org.eclipse.emf.ecore.EReference UML_DEPENDENCY__DEPENDEE -> UML_DEPENDENCY__DEPENDEE
    org.eclipse.emf.ecore.EReference UML_DEPENDENCY__SUPPLIER -> UML_DEPENDENCY__SUPPLIER
    org.eclipse.emf.ecore.EClass UML_NAMED_ELEMENT -> UML_NAMED_ELEMENT
    org.eclipse.emf.ecore.EReference UML_NAMED_ELEMENT__OUTGOING_DEPENDENCIES -> UML_NAMED_ELEMENT__OUTGOING_DEPENDENCIES
    org.eclipse.emf.ecore.EReference UML_NAMED_ELEMENT__DEPENDEES -> UML_NAMED_ELEMENT__DEPENDEES
    org.eclipse.emf.ecore.EAttribute UML_NAMED_ELEMENT__NAME -> UML_NAMED_ELEMENT__NAME
    org.eclipse.emf.ecore.EEnum UML_VISIBILITY -> UML_VISIBILITY
org.sidiff.uml.model.core.UMLComment -> org.sidiff.uml.model.core.UMLComment:
    org.sidiff.uml.model.core.UMLPackage getPackage() -> getPackage
    void setPackage(org.sidiff.uml.model.core.UMLPackage) -> setPackage
    java.lang.String getComment() -> getComment
    void setComment(java.lang.String) -> setComment
    org.eclipse.emf.common.util.EList getElements() -> getElements
org.sidiff.uml.model.core.UMLDependency -> org.sidiff.uml.model.core.UMLDependency:
    org.sidiff.uml.model.core.UMLNamedElement getDependee() -> getDependee
    void setDependee(org.sidiff.uml.model.core.UMLNamedElement) -> setDependee
    org.sidiff.uml.model.core.UMLNamedElement getSupplier() -> getSupplier
    void setSupplier(org.sidiff.uml.model.core.UMLNamedElement) -> setSupplier
org.sidiff.uml.model.core.UMLElement -> org.sidiff.uml.model.core.UMLElement:
    java.lang.String getId() -> getId
    void setId(java.lang.String) -> setId
    org.eclipse.emf.common.util.EList getComments() -> getComments
org.sidiff.uml.model.core.UMLModel -> org.sidiff.uml.model.core.UMLModel:
    org.eclipse.emf.common.util.EList getPackages() -> getPackages
    org.eclipse.emf.common.util.EList getStereotypes() -> getStereotypes
org.sidiff.uml.model.core.UMLNamedElement -> org.sidiff.uml.model.core.UMLNamedElement:
    org.eclipse.emf.common.util.EList getOutgoingDependencies() -> getOutgoingDependencies
    org.eclipse.emf.common.util.EList getDependees() -> getDependees
    java.lang.String getName() -> getName
    void setName(java.lang.String) -> setName
org.sidiff.uml.model.core.UMLPackage -> org.sidiff.uml.model.core.UMLPackage:
    org.sidiff.uml.model.core.UMLModel getModel() -> getModel
    void setModel(org.sidiff.uml.model.core.UMLModel) -> setModel
    org.eclipse.emf.common.util.EList getPackages() -> getPackages
    org.sidiff.uml.model.core.UMLPackage getSuperPackage() -> getSuperPackage
    void setSuperPackage(org.sidiff.uml.model.core.UMLPackage) -> setSuperPackage
    org.eclipse.emf.common.util.EList getClassifiers() -> getClassifiers
    org.eclipse.emf.common.util.EList getStoredComments() -> getStoredComments
    org.eclipse.emf.common.util.EList getAssociations() -> getAssociations
    org.eclipse.emf.common.util.EList getEnumerations() -> getEnumerations
    org.eclipse.emf.common.util.EList getPrimitiveTypes() -> getPrimitiveTypes
org.sidiff.uml.model.core.UMLStereotype -> org.sidiff.uml.model.core.UMLStereotype:
    org.sidiff.uml.model.core.UMLModel getModel() -> getModel
    void setModel(org.sidiff.uml.model.core.UMLModel) -> setModel
    org.eclipse.emf.common.util.EList getStereotypedElements() -> getStereotypedElements
org.sidiff.uml.model.core.UMLStereotypeableElement -> org.sidiff.uml.model.core.UMLStereotypeableElement:
    org.eclipse.emf.common.util.EList getStereotypes() -> getStereotypes
org.sidiff.uml.model.core.UMLVisibility -> org.sidiff.uml.model.core.UMLVisibility:
    org.sidiff.uml.model.core.UMLVisibility PUBLIC -> PUBLIC
    org.sidiff.uml.model.core.UMLVisibility PROTECTED -> PROTECTED
    org.sidiff.uml.model.core.UMLVisibility PRIVATE -> PRIVATE
    org.sidiff.uml.model.core.UMLVisibility PACKAGE -> PACKAGE
    int PUBLIC_VALUE -> PUBLIC_VALUE
    int PROTECTED_VALUE -> PROTECTED_VALUE
    int PRIVATE_VALUE -> PRIVATE_VALUE
    int PACKAGE_VALUE -> PACKAGE_VALUE
    org.sidiff.uml.model.core.UMLVisibility[] VALUES_ARRAY -> VALUES_ARRAY
    java.util.List VALUES -> VALUES
    int value -> value
    java.lang.String name -> name
    java.lang.String literal -> literal
    org.sidiff.uml.model.core.UMLVisibility[] ENUM$VALUES -> ENUM$VALUES
    org.sidiff.uml.model.core.UMLVisibility get(java.lang.String) -> get
    org.sidiff.uml.model.core.UMLVisibility getByName(java.lang.String) -> getByName
    org.sidiff.uml.model.core.UMLVisibility get(int) -> get
    int getValue() -> getValue
    java.lang.String getName() -> getName
    java.lang.String getLiteral() -> getLiteral
    java.lang.String toString() -> toString
    org.sidiff.uml.model.core.UMLVisibility[] values() -> values
    org.sidiff.uml.model.core.UMLVisibility valueOf(java.lang.String) -> valueOf
org.sidiff.uml.model.core.UMLVisibleElement -> org.sidiff.uml.model.core.UMLVisibleElement:
    org.sidiff.uml.model.core.UMLVisibility getVisibility() -> getVisibility
    void setVisibility(org.sidiff.uml.model.core.UMLVisibility) -> setVisibility
org.sidiff.uml.model.core.impl.CoreFactoryImpl -> org.sidiff.uml.model.core.impl.CoreFactoryImpl:
    org.sidiff.uml.model.core.CoreFactory init() -> init
    org.eclipse.emf.ecore.EObject create(org.eclipse.emf.ecore.EClass) -> create
    java.lang.Object createFromString(org.eclipse.emf.ecore.EDataType,java.lang.String) -> createFromString
    java.lang.String convertToString(org.eclipse.emf.ecore.EDataType,java.lang.Object) -> convertToString
    org.sidiff.uml.model.core.UMLPackage createUMLPackage() -> createUMLPackage
    org.sidiff.uml.model.core.UMLStereotypeableElement createUMLStereotypeableElement() -> createUMLStereotypeableElement
    org.sidiff.uml.model.core.UMLStereotype createUMLStereotype() -> createUMLStereotype
    org.sidiff.uml.model.core.UMLModel createUMLModel() -> createUMLModel
    org.sidiff.uml.model.core.UMLComment createUMLComment() -> createUMLComment
    org.sidiff.uml.model.core.UMLDependency createUMLDependency() -> createUMLDependency
    org.sidiff.uml.model.core.UMLVisibility createUMLVisibilityFromString(org.eclipse.emf.ecore.EDataType,java.lang.String) -> createUMLVisibilityFromString
    java.lang.String convertUMLVisibilityToString(org.eclipse.emf.ecore.EDataType,java.lang.Object) -> convertUMLVisibilityToString
    org.sidiff.uml.model.core.CorePackage getCorePackage() -> getCorePackage
    org.sidiff.uml.model.core.CorePackage getPackage() -> getPackage
org.sidiff.uml.model.core.impl.CorePackageImpl -> org.sidiff.uml.model.core.impl.CorePackageImpl:
    org.eclipse.emf.ecore.EClass umlVisibleElementEClass -> umlVisibleElementEClass
    org.eclipse.emf.ecore.EClass umlPackageEClass -> umlPackageEClass
    org.eclipse.emf.ecore.EClass umlStereotypeableElementEClass -> umlStereotypeableElementEClass
    org.eclipse.emf.ecore.EClass umlStereotypeEClass -> umlStereotypeEClass
    org.eclipse.emf.ecore.EClass umlModelEClass -> umlModelEClass
    org.eclipse.emf.ecore.EClass umlElementEClass -> umlElementEClass
    org.eclipse.emf.ecore.EClass umlCommentEClass -> umlCommentEClass
    org.eclipse.emf.ecore.EClass umlDependencyEClass -> umlDependencyEClass
    org.eclipse.emf.ecore.EClass umlNamedElementEClass -> umlNamedElementEClass
    org.eclipse.emf.ecore.EEnum umlVisibilityEEnum -> umlVisibilityEEnum
    boolean isInited -> isInited
    boolean isCreated -> isCreated
    boolean isInitialized -> isInitialized
    org.sidiff.uml.model.core.CorePackage init() -> init
    org.eclipse.emf.ecore.EClass getUMLVisibleElement() -> getUMLVisibleElement
    org.eclipse.emf.ecore.EAttribute getUMLVisibleElement_Visibility() -> getUMLVisibleElement_Visibility
    org.eclipse.emf.ecore.EClass getUMLPackage() -> getUMLPackage
    org.eclipse.emf.ecore.EReference getUMLPackage_Model() -> getUMLPackage_Model
    org.eclipse.emf.ecore.EReference getUMLPackage_Packages() -> getUMLPackage_Packages
    org.eclipse.emf.ecore.EReference getUMLPackage_SuperPackage() -> getUMLPackage_SuperPackage
    org.eclipse.emf.ecore.EReference getUMLPackage_Classifiers() -> getUMLPackage_Classifiers
    org.eclipse.emf.ecore.EReference getUMLPackage_StoredComments() -> getUMLPackage_StoredComments
    org.eclipse.emf.ecore.EReference getUMLPackage_Associations() -> getUMLPackage_Associations
    org.eclipse.emf.ecore.EReference getUMLPackage_Enumerations() -> getUMLPackage_Enumerations
    org.eclipse.emf.ecore.EReference getUMLPackage_PrimitiveTypes() -> getUMLPackage_PrimitiveTypes
    org.eclipse.emf.ecore.EClass getUMLStereotypeableElement() -> getUMLStereotypeableElement
    org.eclipse.emf.ecore.EReference getUMLStereotypeableElement_Stereotypes() -> getUMLStereotypeableElement_Stereotypes
    org.eclipse.emf.ecore.EClass getUMLStereotype() -> getUMLStereotype
    org.eclipse.emf.ecore.EReference getUMLStereotype_Model() -> getUMLStereotype_Model
    org.eclipse.emf.ecore.EReference getUMLStereotype_StereotypedElements() -> getUMLStereotype_StereotypedElements
    org.eclipse.emf.ecore.EClass getUMLModel() -> getUMLModel
    org.eclipse.emf.ecore.EReference getUMLModel_Packages() -> getUMLModel_Packages
    org.eclipse.emf.ecore.EReference getUMLModel_Stereotypes() -> getUMLModel_Stereotypes
    org.eclipse.emf.ecore.EClass getUMLElement() -> getUMLElement
    org.eclipse.emf.ecore.EAttribute getUMLElement_Id() -> getUMLElement_Id
    org.eclipse.emf.ecore.EReference getUMLElement_Comments() -> getUMLElement_Comments
    org.eclipse.emf.ecore.EClass getUMLComment() -> getUMLComment
    org.eclipse.emf.ecore.EReference getUMLComment_Package() -> getUMLComment_Package
    org.eclipse.emf.ecore.EAttribute getUMLComment_Comment() -> getUMLComment_Comment
    org.eclipse.emf.ecore.EReference getUMLComment_Elements() -> getUMLComment_Elements
    org.eclipse.emf.ecore.EClass getUMLDependency() -> getUMLDependency
    org.eclipse.emf.ecore.EReference getUMLDependency_Dependee() -> getUMLDependency_Dependee
    org.eclipse.emf.ecore.EReference getUMLDependency_Supplier() -> getUMLDependency_Supplier
    org.eclipse.emf.ecore.EClass getUMLNamedElement() -> getUMLNamedElement
    org.eclipse.emf.ecore.EReference getUMLNamedElement_OutgoingDependencies() -> getUMLNamedElement_OutgoingDependencies
    org.eclipse.emf.ecore.EReference getUMLNamedElement_Dependees() -> getUMLNamedElement_Dependees
    org.eclipse.emf.ecore.EAttribute getUMLNamedElement_Name() -> getUMLNamedElement_Name
    org.eclipse.emf.ecore.EEnum getUMLVisibility() -> getUMLVisibility
    org.sidiff.uml.model.core.CoreFactory getCoreFactory() -> getCoreFactory
    void createPackageContents() -> createPackageContents
    void initializePackageContents() -> initializePackageContents
    void createINCOMINGAnnotations() -> createINCOMINGAnnotations
    void createIGNOREDIFFAnnotations() -> createIGNOREDIFFAnnotations
org.sidiff.uml.model.core.impl.UMLCommentImpl -> org.sidiff.uml.model.core.impl.UMLCommentImpl:
    java.lang.String COMMENT_EDEFAULT -> COMMENT_EDEFAULT
    java.lang.String comment -> comment
    org.eclipse.emf.common.util.EList elements -> elements
    org.eclipse.emf.ecore.EClass eStaticClass() -> eStaticClass
    org.sidiff.uml.model.core.UMLPackage getPackage() -> getPackage
    org.eclipse.emf.common.notify.NotificationChain basicSetPackage(org.sidiff.uml.model.core.UMLPackage,org.eclipse.emf.common.notify.NotificationChain) -> basicSetPackage
    void setPackage(org.sidiff.uml.model.core.UMLPackage) -> setPackage
    java.lang.String getComment() -> getComment
    void setComment(java.lang.String) -> setComment
    org.eclipse.emf.common.util.EList getElements() -> getElements
    org.eclipse.emf.common.notify.NotificationChain eInverseAdd(org.eclipse.emf.ecore.InternalEObject,int,org.eclipse.emf.common.notify.NotificationChain) -> eInverseAdd
    org.eclipse.emf.common.notify.NotificationChain eInverseRemove(org.eclipse.emf.ecore.InternalEObject,int,org.eclipse.emf.common.notify.NotificationChain) -> eInverseRemove
    org.eclipse.emf.common.notify.NotificationChain eBasicRemoveFromContainerFeature(org.eclipse.emf.common.notify.NotificationChain) -> eBasicRemoveFromContainerFeature
    java.lang.Object eGet(int,boolean,boolean) -> eGet
    void eSet(int,java.lang.Object) -> eSet
    void eUnset(int) -> eUnset
    boolean eIsSet(int) -> eIsSet
    java.lang.String toString() -> toString
org.sidiff.uml.model.core.impl.UMLDependencyImpl -> org.sidiff.uml.model.core.impl.UMLDependencyImpl:
    org.eclipse.emf.common.util.EList stereotypes -> stereotypes
    org.sidiff.uml.model.core.UMLNamedElement supplier -> supplier
    org.eclipse.emf.ecore.EClass eStaticClass() -> eStaticClass
    org.eclipse.emf.common.util.EList getStereotypes() -> getStereotypes
    org.sidiff.uml.model.core.UMLNamedElement getDependee() -> getDependee
    org.eclipse.emf.common.notify.NotificationChain basicSetDependee(org.sidiff.uml.model.core.UMLNamedElement,org.eclipse.emf.common.notify.NotificationChain) -> basicSetDependee
    void setDependee(org.sidiff.uml.model.core.UMLNamedElement) -> setDependee
    org.sidiff.uml.model.core.UMLNamedElement getSupplier() -> getSupplier
    org.sidiff.uml.model.core.UMLNamedElement basicGetSupplier() -> basicGetSupplier
    org.eclipse.emf.common.notify.NotificationChain basicSetSupplier(org.sidiff.uml.model.core.UMLNamedElement,org.eclipse.emf.common.notify.NotificationChain) -> basicSetSupplier
    void setSupplier(org.sidiff.uml.model.core.UMLNamedElement) -> setSupplier
    org.eclipse.emf.common.notify.NotificationChain eInverseAdd(org.eclipse.emf.ecore.InternalEObject,int,org.eclipse.emf.common.notify.NotificationChain) -> eInverseAdd
    org.eclipse.emf.common.notify.NotificationChain eInverseRemove(org.eclipse.emf.ecore.InternalEObject,int,org.eclipse.emf.common.notify.NotificationChain) -> eInverseRemove
    org.eclipse.emf.common.notify.NotificationChain eBasicRemoveFromContainerFeature(org.eclipse.emf.common.notify.NotificationChain) -> eBasicRemoveFromContainerFeature
    java.lang.Object eGet(int,boolean,boolean) -> eGet
    void eSet(int,java.lang.Object) -> eSet
    void eUnset(int) -> eUnset
    boolean eIsSet(int) -> eIsSet
    int eBaseStructuralFeatureID(int,java.lang.Class) -> eBaseStructuralFeatureID
    int eDerivedStructuralFeatureID(int,java.lang.Class) -> eDerivedStructuralFeatureID
org.sidiff.uml.model.core.impl.UMLElementImpl -> org.sidiff.uml.model.core.impl.UMLElementImpl:
    java.lang.String ID_EDEFAULT -> ID_EDEFAULT
    java.lang.String id -> id
    org.eclipse.emf.common.util.EList comments -> comments
    org.eclipse.emf.ecore.EClass eStaticClass() -> eStaticClass
    java.lang.String getId() -> getId
    void setId(java.lang.String) -> setId
    org.eclipse.emf.common.util.EList getComments() -> getComments
    org.eclipse.emf.common.notify.NotificationChain eInverseAdd(org.eclipse.emf.ecore.InternalEObject,int,org.eclipse.emf.common.notify.NotificationChain) -> eInverseAdd
    org.eclipse.emf.common.notify.NotificationChain eInverseRemove(org.eclipse.emf.ecore.InternalEObject,int,org.eclipse.emf.common.notify.NotificationChain) -> eInverseRemove
    java.lang.Object eGet(int,boolean,boolean) -> eGet
    void eSet(int,java.lang.Object) -> eSet
    void eUnset(int) -> eUnset
    boolean eIsSet(int) -> eIsSet
    java.lang.String toString() -> toString
org.sidiff.uml.model.core.impl.UMLModelImpl -> org.sidiff.uml.model.core.impl.UMLModelImpl:
    org.eclipse.emf.common.util.EList packages -> packages
    org.eclipse.emf.common.util.EList stereotypes -> stereotypes
    org.eclipse.emf.ecore.EClass eStaticClass() -> eStaticClass
    org.eclipse.emf.common.util.EList getPackages() -> getPackages
    org.eclipse.emf.common.util.EList getStereotypes() -> getStereotypes
    org.eclipse.emf.common.notify.NotificationChain eInverseAdd(org.eclipse.emf.ecore.InternalEObject,int,org.eclipse.emf.common.notify.NotificationChain) -> eInverseAdd
    org.eclipse.emf.common.notify.NotificationChain eInverseRemove(org.eclipse.emf.ecore.InternalEObject,int,org.eclipse.emf.common.notify.NotificationChain) -> eInverseRemove
    java.lang.Object eGet(int,boolean,boolean) -> eGet
    void eSet(int,java.lang.Object) -> eSet
    void eUnset(int) -> eUnset
    boolean eIsSet(int) -> eIsSet
org.sidiff.uml.model.core.impl.UMLNamedElementImpl -> org.sidiff.uml.model.core.impl.UMLNamedElementImpl:
    org.eclipse.emf.common.util.EList outgoingDependencies -> outgoingDependencies
    org.eclipse.emf.common.util.EList dependees -> dependees
    java.lang.String NAME_EDEFAULT -> NAME_EDEFAULT
    java.lang.String name -> name
    org.eclipse.emf.ecore.EClass eStaticClass() -> eStaticClass
    org.eclipse.emf.common.util.EList getOutgoingDependencies() -> getOutgoingDependencies
    org.eclipse.emf.common.util.EList getDependees() -> getDependees
    java.lang.String getName() -> getName
    void setName(java.lang.String) -> setName
    org.eclipse.emf.common.notify.NotificationChain eInverseAdd(org.eclipse.emf.ecore.InternalEObject,int,org.eclipse.emf.common.notify.NotificationChain) -> eInverseAdd
    org.eclipse.emf.common.notify.NotificationChain eInverseRemove(org.eclipse.emf.ecore.InternalEObject,int,org.eclipse.emf.common.notify.NotificationChain) -> eInverseRemove
    java.lang.Object eGet(int,boolean,boolean) -> eGet
    void eSet(int,java.lang.Object) -> eSet
    void eUnset(int) -> eUnset
    boolean eIsSet(int) -> eIsSet
    java.lang.String toString() -> toString
org.sidiff.uml.model.core.impl.UMLPackageImpl -> org.sidiff.uml.model.core.impl.UMLPackageImpl:
    org.eclipse.emf.common.util.EList stereotypes -> stereotypes
    org.sidiff.uml.model.core.UMLVisibility VISIBILITY_EDEFAULT -> VISIBILITY_EDEFAULT
    org.sidiff.uml.model.core.UMLVisibility visibility -> visibility
    org.eclipse.emf.common.util.EList packages -> packages
    org.eclipse.emf.common.util.EList classifiers -> classifiers
    org.eclipse.emf.common.util.EList storedComments -> storedComments
    org.eclipse.emf.common.util.EList associations -> associations
    org.eclipse.emf.common.util.EList enumerations -> enumerations
    org.eclipse.emf.common.util.EList primitiveTypes -> primitiveTypes
    org.eclipse.emf.ecore.EClass eStaticClass() -> eStaticClass
    org.eclipse.emf.common.util.EList getStereotypes() -> getStereotypes
    org.sidiff.uml.model.core.UMLVisibility getVisibility() -> getVisibility
    void setVisibility(org.sidiff.uml.model.core.UMLVisibility) -> setVisibility
    org.sidiff.uml.model.core.UMLModel getModel() -> getModel
    org.eclipse.emf.common.notify.NotificationChain basicSetModel(org.sidiff.uml.model.core.UMLModel,org.eclipse.emf.common.notify.NotificationChain) -> basicSetModel
    void setModel(org.sidiff.uml.model.core.UMLModel) -> setModel
    org.eclipse.emf.common.util.EList getPackages() -> getPackages
    org.sidiff.uml.model.core.UMLPackage getSuperPackage() -> getSuperPackage
    org.eclipse.emf.common.notify.NotificationChain basicSetSuperPackage(org.sidiff.uml.model.core.UMLPackage,org.eclipse.emf.common.notify.NotificationChain) -> basicSetSuperPackage
    void setSuperPackage(org.sidiff.uml.model.core.UMLPackage) -> setSuperPackage
    org.eclipse.emf.common.util.EList getClassifiers() -> getClassifiers
    org.eclipse.emf.common.util.EList getStoredComments() -> getStoredComments
    org.eclipse.emf.common.util.EList getAssociations() -> getAssociations
    org.eclipse.emf.common.util.EList getEnumerations() -> getEnumerations
    org.eclipse.emf.common.util.EList getPrimitiveTypes() -> getPrimitiveTypes
    org.eclipse.emf.common.notify.NotificationChain eInverseAdd(org.eclipse.emf.ecore.InternalEObject,int,org.eclipse.emf.common.notify.NotificationChain) -> eInverseAdd
    org.eclipse.emf.common.notify.NotificationChain eInverseRemove(org.eclipse.emf.ecore.InternalEObject,int,org.eclipse.emf.common.notify.NotificationChain) -> eInverseRemove
    org.eclipse.emf.common.notify.NotificationChain eBasicRemoveFromContainerFeature(org.eclipse.emf.common.notify.NotificationChain) -> eBasicRemoveFromContainerFeature
    java.lang.Object eGet(int,boolean,boolean) -> eGet
    void eSet(int,java.lang.Object) -> eSet
    void eUnset(int) -> eUnset
    boolean eIsSet(int) -> eIsSet
    int eBaseStructuralFeatureID(int,java.lang.Class) -> eBaseStructuralFeatureID
    int eDerivedStructuralFeatureID(int,java.lang.Class) -> eDerivedStructuralFeatureID
    java.lang.String toString() -> toString
org.sidiff.uml.model.core.impl.UMLStereotypeImpl -> org.sidiff.uml.model.core.impl.UMLStereotypeImpl:
    org.eclipse.emf.common.util.EList stereotypedElements -> stereotypedElements
    org.eclipse.emf.ecore.EClass eStaticClass() -> eStaticClass
    org.sidiff.uml.model.core.UMLModel getModel() -> getModel
    org.eclipse.emf.common.notify.NotificationChain basicSetModel(org.sidiff.uml.model.core.UMLModel,org.eclipse.emf.common.notify.NotificationChain) -> basicSetModel
    void setModel(org.sidiff.uml.model.core.UMLModel) -> setModel
    org.eclipse.emf.common.util.EList getStereotypedElements() -> getStereotypedElements
    org.eclipse.emf.common.notify.NotificationChain eInverseAdd(org.eclipse.emf.ecore.InternalEObject,int,org.eclipse.emf.common.notify.NotificationChain) -> eInverseAdd
    org.eclipse.emf.common.notify.NotificationChain eInverseRemove(org.eclipse.emf.ecore.InternalEObject,int,org.eclipse.emf.common.notify.NotificationChain) -> eInverseRemove
    org.eclipse.emf.common.notify.NotificationChain eBasicRemoveFromContainerFeature(org.eclipse.emf.common.notify.NotificationChain) -> eBasicRemoveFromContainerFeature
    java.lang.Object eGet(int,boolean,boolean) -> eGet
    void eSet(int,java.lang.Object) -> eSet
    void eUnset(int) -> eUnset
    boolean eIsSet(int) -> eIsSet
org.sidiff.uml.model.core.impl.UMLStereotypeableElementImpl -> org.sidiff.uml.model.core.impl.UMLStereotypeableElementImpl:
    org.eclipse.emf.common.util.EList stereotypes -> stereotypes
    org.eclipse.emf.ecore.EClass eStaticClass() -> eStaticClass
    org.eclipse.emf.common.util.EList getStereotypes() -> getStereotypes
    org.eclipse.emf.common.notify.NotificationChain eInverseAdd(org.eclipse.emf.ecore.InternalEObject,int,org.eclipse.emf.common.notify.NotificationChain) -> eInverseAdd
    org.eclipse.emf.common.notify.NotificationChain eInverseRemove(org.eclipse.emf.ecore.InternalEObject,int,org.eclipse.emf.common.notify.NotificationChain) -> eInverseRemove
    java.lang.Object eGet(int,boolean,boolean) -> eGet
    void eSet(int,java.lang.Object) -> eSet
    void eUnset(int) -> eUnset
    boolean eIsSet(int) -> eIsSet
org.sidiff.uml.model.core.impl.UMLVisibleElementImpl -> org.sidiff.uml.model.core.impl.UMLVisibleElementImpl:
    org.sidiff.uml.model.core.UMLVisibility VISIBILITY_EDEFAULT -> VISIBILITY_EDEFAULT
    org.sidiff.uml.model.core.UMLVisibility visibility -> visibility
    org.eclipse.emf.ecore.EClass eStaticClass() -> eStaticClass
    org.sidiff.uml.model.core.UMLVisibility getVisibility() -> getVisibility
    void setVisibility(org.sidiff.uml.model.core.UMLVisibility) -> setVisibility
    java.lang.Object eGet(int,boolean,boolean) -> eGet
    void eSet(int,java.lang.Object) -> eSet
    void eUnset(int) -> eUnset
    boolean eIsSet(int) -> eIsSet
    java.lang.String toString() -> toString
org.sidiff.uml.model.core.util.CoreAdapterFactory -> org.sidiff.uml.model.core.util.CoreAdapterFactory:
    org.sidiff.uml.model.core.CorePackage modelPackage -> modelPackage
    org.sidiff.uml.model.core.util.CoreSwitch modelSwitch -> modelSwitch
    boolean isFactoryForType(java.lang.Object) -> isFactoryForType
    org.eclipse.emf.common.notify.Adapter createAdapter(org.eclipse.emf.common.notify.Notifier) -> createAdapter
    org.eclipse.emf.common.notify.Adapter createUMLVisibleElementAdapter() -> createUMLVisibleElementAdapter
    org.eclipse.emf.common.notify.Adapter createUMLPackageAdapter() -> createUMLPackageAdapter
    org.eclipse.emf.common.notify.Adapter createUMLStereotypeableElementAdapter() -> createUMLStereotypeableElementAdapter
    org.eclipse.emf.common.notify.Adapter createUMLStereotypeAdapter() -> createUMLStereotypeAdapter
    org.eclipse.emf.common.notify.Adapter createUMLModelAdapter() -> createUMLModelAdapter
    org.eclipse.emf.common.notify.Adapter createUMLElementAdapter() -> createUMLElementAdapter
    org.eclipse.emf.common.notify.Adapter createUMLCommentAdapter() -> createUMLCommentAdapter
    org.eclipse.emf.common.notify.Adapter createUMLDependencyAdapter() -> createUMLDependencyAdapter
    org.eclipse.emf.common.notify.Adapter createUMLNamedElementAdapter() -> createUMLNamedElementAdapter
    org.eclipse.emf.common.notify.Adapter createEObjectAdapter() -> createEObjectAdapter
org.sidiff.uml.model.core.util.CoreAdapterFactory$1 -> org.sidiff.uml.model.core.util.CoreAdapterFactory$1:
    org.sidiff.uml.model.core.util.CoreAdapterFactory this$0 -> this$0
    org.eclipse.emf.common.notify.Adapter caseUMLVisibleElement(org.sidiff.uml.model.core.UMLVisibleElement) -> caseUMLVisibleElement
    org.eclipse.emf.common.notify.Adapter caseUMLPackage(org.sidiff.uml.model.core.UMLPackage) -> caseUMLPackage
    org.eclipse.emf.common.notify.Adapter caseUMLStereotypeableElement(org.sidiff.uml.model.core.UMLStereotypeableElement) -> caseUMLStereotypeableElement
    org.eclipse.emf.common.notify.Adapter caseUMLStereotype(org.sidiff.uml.model.core.UMLStereotype) -> caseUMLStereotype
    org.eclipse.emf.common.notify.Adapter caseUMLModel(org.sidiff.uml.model.core.UMLModel) -> caseUMLModel
    org.eclipse.emf.common.notify.Adapter caseUMLElement(org.sidiff.uml.model.core.UMLElement) -> caseUMLElement
    org.eclipse.emf.common.notify.Adapter caseUMLComment(org.sidiff.uml.model.core.UMLComment) -> caseUMLComment
    org.eclipse.emf.common.notify.Adapter caseUMLDependency(org.sidiff.uml.model.core.UMLDependency) -> caseUMLDependency
    org.eclipse.emf.common.notify.Adapter caseUMLNamedElement(org.sidiff.uml.model.core.UMLNamedElement) -> caseUMLNamedElement
    org.eclipse.emf.common.notify.Adapter defaultCase(org.eclipse.emf.ecore.EObject) -> defaultCase
    java.lang.Object caseUMLNamedElement(org.sidiff.uml.model.core.UMLNamedElement) -> caseUMLNamedElement
    java.lang.Object caseUMLStereotypeableElement(org.sidiff.uml.model.core.UMLStereotypeableElement) -> caseUMLStereotypeableElement
    java.lang.Object caseUMLElement(org.sidiff.uml.model.core.UMLElement) -> caseUMLElement
    java.lang.Object defaultCase(org.eclipse.emf.ecore.EObject) -> defaultCase
    java.lang.Object caseUMLStereotype(org.sidiff.uml.model.core.UMLStereotype) -> caseUMLStereotype
    java.lang.Object caseUMLPackage(org.sidiff.uml.model.core.UMLPackage) -> caseUMLPackage
    java.lang.Object caseUMLModel(org.sidiff.uml.model.core.UMLModel) -> caseUMLModel
    java.lang.Object caseUMLDependency(org.sidiff.uml.model.core.UMLDependency) -> caseUMLDependency
    java.lang.Object caseUMLComment(org.sidiff.uml.model.core.UMLComment) -> caseUMLComment
    java.lang.Object caseUMLVisibleElement(org.sidiff.uml.model.core.UMLVisibleElement) -> caseUMLVisibleElement
org.sidiff.uml.model.core.util.CoreSwitch -> org.sidiff.uml.model.core.util.CoreSwitch:
    org.sidiff.uml.model.core.CorePackage modelPackage -> modelPackage
    java.lang.Object doSwitch(org.eclipse.emf.ecore.EObject) -> doSwitch
    java.lang.Object doSwitch(org.eclipse.emf.ecore.EClass,org.eclipse.emf.ecore.EObject) -> doSwitch
    java.lang.Object doSwitch(int,org.eclipse.emf.ecore.EObject) -> doSwitch
    java.lang.Object caseUMLVisibleElement(org.sidiff.uml.model.core.UMLVisibleElement) -> caseUMLVisibleElement
    java.lang.Object caseUMLPackage(org.sidiff.uml.model.core.UMLPackage) -> caseUMLPackage
    java.lang.Object caseUMLStereotypeableElement(org.sidiff.uml.model.core.UMLStereotypeableElement) -> caseUMLStereotypeableElement
    java.lang.Object caseUMLStereotype(org.sidiff.uml.model.core.UMLStereotype) -> caseUMLStereotype
    java.lang.Object caseUMLModel(org.sidiff.uml.model.core.UMLModel) -> caseUMLModel
    java.lang.Object caseUMLElement(org.sidiff.uml.model.core.UMLElement) -> caseUMLElement
    java.lang.Object caseUMLComment(org.sidiff.uml.model.core.UMLComment) -> caseUMLComment
    java.lang.Object caseUMLDependency(org.sidiff.uml.model.core.UMLDependency) -> caseUMLDependency
    java.lang.Object caseUMLNamedElement(org.sidiff.uml.model.core.UMLNamedElement) -> caseUMLNamedElement
    java.lang.Object defaultCase(org.eclipse.emf.ecore.EObject) -> defaultCase
org.sidiff.uml.model.impl.DummyImpl -> org.sidiff.uml.model.impl.DummyImpl:
    org.eclipse.emf.ecore.EClass eStaticClass() -> eStaticClass
org.sidiff.uml.model.impl.ModelFactoryImpl -> org.sidiff.uml.model.impl.ModelFactoryImpl:
    org.sidiff.uml.model.ModelFactory init() -> init
    org.eclipse.emf.ecore.EObject create(org.eclipse.emf.ecore.EClass) -> create
    org.sidiff.uml.model.ModelPackage getModelPackage() -> getModelPackage
    org.sidiff.uml.model.ModelPackage getPackage() -> getPackage
org.sidiff.uml.model.impl.ModelPackageImpl -> org.sidiff.uml.model.impl.ModelPackageImpl:
    org.eclipse.emf.ecore.EClass dummyEClass -> dummyEClass
    boolean isInited -> isInited
    boolean isCreated -> isCreated
    boolean isInitialized -> isInitialized
    org.sidiff.uml.model.ModelPackage init() -> init
    org.eclipse.emf.ecore.EClass getDummy() -> getDummy
    org.sidiff.uml.model.ModelFactory getModelFactory() -> getModelFactory
    void createPackageContents() -> createPackageContents
    void initializePackageContents() -> initializePackageContents
org.sidiff.uml.model.packages.Dummy -> org.sidiff.uml.model.packages.Dummy:
org.sidiff.uml.model.packages.PackagesFactory -> org.sidiff.uml.model.packages.PackagesFactory:
    org.sidiff.uml.model.packages.PackagesFactory eINSTANCE -> eINSTANCE
    org.sidiff.uml.model.packages.PackagesPackage getPackagesPackage() -> getPackagesPackage
org.sidiff.uml.model.packages.PackagesPackage -> org.sidiff.uml.model.packages.PackagesPackage:
    java.lang.String eNAME -> eNAME
    java.lang.String eNS_URI -> eNS_URI
    java.lang.String eNS_PREFIX -> eNS_PREFIX
    org.sidiff.uml.model.packages.PackagesPackage eINSTANCE -> eINSTANCE
    int DUMMY -> DUMMY
    int DUMMY_FEATURE_COUNT -> DUMMY_FEATURE_COUNT
    org.eclipse.emf.ecore.EClass getDummy() -> getDummy
    org.sidiff.uml.model.packages.PackagesFactory getPackagesFactory() -> getPackagesFactory
org.sidiff.uml.model.packages.PackagesPackage$Literals -> org.sidiff.uml.model.packages.PackagesPackage$Literals:
    org.eclipse.emf.ecore.EClass DUMMY -> DUMMY
org.sidiff.uml.model.packages.impl.DummyImpl -> org.sidiff.uml.model.packages.impl.DummyImpl:
    org.eclipse.emf.ecore.EClass eStaticClass() -> eStaticClass
org.sidiff.uml.model.packages.impl.PackagesFactoryImpl -> org.sidiff.uml.model.packages.impl.PackagesFactoryImpl:
    org.sidiff.uml.model.packages.PackagesFactory init() -> init
    org.eclipse.emf.ecore.EObject create(org.eclipse.emf.ecore.EClass) -> create
    org.sidiff.uml.model.packages.PackagesPackage getPackagesPackage() -> getPackagesPackage
    org.sidiff.uml.model.packages.PackagesPackage getPackage() -> getPackage
org.sidiff.uml.model.packages.impl.PackagesPackageImpl -> org.sidiff.uml.model.packages.impl.PackagesPackageImpl:
    org.eclipse.emf.ecore.EClass dummyEClass -> dummyEClass
    boolean isInited -> isInited
    boolean isCreated -> isCreated
    boolean isInitialized -> isInitialized
    org.sidiff.uml.model.packages.PackagesPackage init() -> init
    org.eclipse.emf.ecore.EClass getDummy() -> getDummy
    org.sidiff.uml.model.packages.PackagesFactory getPackagesFactory() -> getPackagesFactory
    void createPackageContents() -> createPackageContents
    void initializePackageContents() -> initializePackageContents
org.sidiff.uml.model.packages.util.PackagesAdapterFactory -> org.sidiff.uml.model.packages.util.PackagesAdapterFactory:
    org.sidiff.uml.model.packages.PackagesPackage modelPackage -> modelPackage
    org.sidiff.uml.model.packages.util.PackagesSwitch modelSwitch -> modelSwitch
    boolean isFactoryForType(java.lang.Object) -> isFactoryForType
    org.eclipse.emf.common.notify.Adapter createAdapter(org.eclipse.emf.common.notify.Notifier) -> createAdapter
    org.eclipse.emf.common.notify.Adapter createDummyAdapter() -> createDummyAdapter
    org.eclipse.emf.common.notify.Adapter createEObjectAdapter() -> createEObjectAdapter
org.sidiff.uml.model.packages.util.PackagesAdapterFactory$1 -> org.sidiff.uml.model.packages.util.PackagesAdapterFactory$1:
    org.sidiff.uml.model.packages.util.PackagesAdapterFactory this$0 -> this$0
    org.eclipse.emf.common.notify.Adapter caseDummy(org.sidiff.uml.model.packages.Dummy) -> caseDummy
    org.eclipse.emf.common.notify.Adapter defaultCase(org.eclipse.emf.ecore.EObject) -> defaultCase
    java.lang.Object caseDummy(org.sidiff.uml.model.packages.Dummy) -> caseDummy
    java.lang.Object defaultCase(org.eclipse.emf.ecore.EObject) -> defaultCase
org.sidiff.uml.model.packages.util.PackagesSwitch -> org.sidiff.uml.model.packages.util.PackagesSwitch:
    org.sidiff.uml.model.packages.PackagesPackage modelPackage -> modelPackage
    java.lang.Object doSwitch(org.eclipse.emf.ecore.EObject) -> doSwitch
    java.lang.Object doSwitch(org.eclipse.emf.ecore.EClass,org.eclipse.emf.ecore.EObject) -> doSwitch
    java.lang.Object doSwitch(int,org.eclipse.emf.ecore.EObject) -> doSwitch
    java.lang.Object caseDummy(org.sidiff.uml.model.packages.Dummy) -> caseDummy
    java.lang.Object defaultCase(org.eclipse.emf.ecore.EObject) -> defaultCase
org.sidiff.uml.model.util.ModelAdapterFactory -> org.sidiff.uml.model.util.ModelAdapterFactory:
    org.sidiff.uml.model.ModelPackage modelPackage -> modelPackage
    org.sidiff.uml.model.util.ModelSwitch modelSwitch -> modelSwitch
    boolean isFactoryForType(java.lang.Object) -> isFactoryForType
    org.eclipse.emf.common.notify.Adapter createAdapter(org.eclipse.emf.common.notify.Notifier) -> createAdapter
    org.eclipse.emf.common.notify.Adapter createDummyAdapter() -> createDummyAdapter
    org.eclipse.emf.common.notify.Adapter createEObjectAdapter() -> createEObjectAdapter
org.sidiff.uml.model.util.ModelAdapterFactory$1 -> org.sidiff.uml.model.util.ModelAdapterFactory$1:
    org.sidiff.uml.model.util.ModelAdapterFactory this$0 -> this$0
    org.eclipse.emf.common.notify.Adapter caseDummy(org.sidiff.uml.model.Dummy) -> caseDummy
    org.eclipse.emf.common.notify.Adapter defaultCase(org.eclipse.emf.ecore.EObject) -> defaultCase
    java.lang.Object caseDummy(org.sidiff.uml.model.Dummy) -> caseDummy
    java.lang.Object defaultCase(org.eclipse.emf.ecore.EObject) -> defaultCase
org.sidiff.uml.model.util.ModelSwitch -> org.sidiff.uml.model.util.ModelSwitch:
    org.sidiff.uml.model.ModelPackage modelPackage -> modelPackage
    java.lang.Object doSwitch(org.eclipse.emf.ecore.EObject) -> doSwitch
    java.lang.Object doSwitch(org.eclipse.emf.ecore.EClass,org.eclipse.emf.ecore.EObject) -> doSwitch
    java.lang.Object doSwitch(int,org.eclipse.emf.ecore.EObject) -> doSwitch
    java.lang.Object caseDummy(org.sidiff.uml.model.Dummy) -> caseDummy
    java.lang.Object defaultCase(org.eclipse.emf.ecore.EObject) -> defaultCase
