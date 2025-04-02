#!/bin/sh

nbdir="/users/sidiff/nightly-build"

rm -rf $nbdir/bundles

dos2unix $nbdir/build/scripts/checkout.txt

for f in `cat $nbdir/build/scripts/checkout.txt`; do
svn checkout http://svn.informatik.uni-siegen.de/SiDiff/trunk$f $nbdir/bundles
svn checkout http://svn.informatik.uni-siegen.de/SiDiff/trunk/apps/org.sidiff.pipeline.app.tools $nbdir/bundles/org.sidiff.pipeline.app.tools
svn checkout http://svn.informatik.uni-siegen.de/SiDiff/trunk/research/pipelining/org.sidiff.pipeline.matching $nbdir/bundles/org.sidiff.pipeline.matching
svn checkout http://svn.informatik.uni-siegen.de/SiDiff/trunk/tools/org.sidiff.core.configurator $nbdir/bundles/org.sidiff.core.configurator
svn checkout http://svn.informatik.uni-siegen.de/SiDiff/trunk/research/pipelining/org.sidiff.pipeline.correspondences.model $nbdir/bundles/org.sidiff.pipeline.correspondences.model
svn checkout http://svn.informatik.uni-siegen.de/SiDiff/trunk/research/pipelining/org.sidiff.pipeline.difference.model $nbdir/bundles/org.sidiff.pipeline.difference.model
rm -rf /users/sidiff/nightly-build/bundles/.svn
rm -rf /users/sidiff/nightly-build/bundles/org.sidiff.common.emf/experimental/
rm -rf /users/sidiff/nightly-build/bundles/org.sidiff.common/experimental/
done


svn checkout http://svn.informatik.uni-siegen.de/SiDiff/trunk/features $nbdir/build/features

