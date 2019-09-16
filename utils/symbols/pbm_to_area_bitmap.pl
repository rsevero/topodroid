#!/usr/bin/perl
#
# convert PBM files to Topodroid area symbol bitmap
#
# --------------------------------------------------------
#  Copyright This software is distributed under GPL-3.0 or later
#  See the file COPYING.
# --------------------------------------------------------
#

use strict;
use warnings;

sub getLineType($) {
	my ($line) = @_;

	# Removing all kinds of newlines
	$line =~ s/\r|\n//g;

	# Trimming
	$line =~ s/^\s+|\s+$//g;

	if($line eq 'P1') {
		return 1;
	} elsif($line eq '') {
		return 2;
	} elsif(substr($line, 0, 1) eq '#' ) {
		return 3;
	} elsif($line =~ /^(\d+)\s+(\d+)$/) {
		return 4;
	} elsif($line =~ /^([01]+)$/) {
		return 5;
	} else {
		return 7;
	}
}

sub process($) {
	my $state = 0;

	my ($line) = @_;

	# States reference:
	#
	# 0 -> initial
	# 1 -> magic number identified
	# 2 -> width/height identified
	# 3 -> all data read

	# Event reference
	#
	# 1 -> magic number read
	# 2 -> empty line read
	# 3 -> comment line read
	# 4 -> width/height line read
	# 5 -> data line read
	# 6 -> eof read
	# 7 -> unidentified line

	$lineType = getLineType($line);
	if($state == 0) {

	} elsif($state == 1) {

	} elsif ($state == 2) {

	} elsif ($state == 3) {

	}
}
 
my $pbm = $ARGV[0];
my $output = '';

open my $info, $pbm or die "Could not open $pbm: $!";

my $txt = $pbm . '.txt';
open(OUTPUT, '>', $txt) or die $!;

while(my $line = <$info>)  { 
	print OUTPUT 'Tipo de linha identificado: ' . getLineType($line) . ' - Linha: "' . 
		$line . "\"\n";  
    $output = process($line);
    if(length($output)) {
    	print OUTPUT $output;
    }
}

close $info;
close OUTPUT;
