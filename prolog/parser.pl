:- use_module(library(regex)).
:- dynamic word/2.


sentence -->
    {retractall(word(_, _))},
	subject,
	verb,
	object.

subject -->
	article,
	adjective,
	noun.

object -->
	article,
	adjective_acc,
	noun_acc.
	
adjective([Word|X], X) :-
	Word =~ '.+a',
    assert(word(Word, 'melléknév, egyesszám, alanyeset')).

adjective([Word|X], X) :-
	Word =~ '.+aj',
    assert(word(Word, 'melléknév, többesszám, alanyeset')).

adjective --> [].

adjective_acc([Word|X], X) :-
	Word =~ '.+an',
    assert(word(Word, 'melléknév, egyesszám, tárgyeset')).

adjective_acc([Word|X], X) :-
	Word =~ '.+ajn',
    assert(word(Word, 'melléknév, többesszám, tárgyeset')).

adjective_acc --> [].

adverb([Word|X], X) :-
	Word =~ '.+e',
    assert(word(Word, 'határozószó')).

article --> [la], {assert(word('la', 'határozott névelő'))}.
article --> [].

infinitive([Word|X], X) :-
	Word =~ '.+i',
    assert(word(Word, 'főnévi igenév')).

noun([Word|X], X) :-
	Word =~ '.+o',
    assert(word(Word, 'főnév, egyesszám, alanyeset')).

noun([Word|X], X) :-
	Word =~ '.+oj',
    assert(word(Word, 'főnév, többesszám, alanyeset')).

noun_acc([Word|X], X) :-
	Word =~ '.+on',
    assert(word(Word, 'főnév, egyesszám, tárgyeset')).

noun_acc([Word|X], X) :-
	Word =~ '.+ojn',
    assert(word(Word, 'főnév, többesszám, tárgyeset')).

noun_acc --> [].

verb([Word|X], X) :-
	Word =~ '.+as',
    assert(word(Word, 'ige, jelen idő')).

verb([Word|X], X) :-
	Word =~ '.+is',
    assert(word(Word, 'ige, múlt idő')).

verb([Word|X], X) :-
	Word =~ '.+os',
    assert(word(Word, 'ige, jövő idő')).