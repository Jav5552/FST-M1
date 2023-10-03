import pytest

@pytest.fixture
def wallet():
    amount=0

    return amount

@pytest.mark.parametrize("earned,spent,Total",[(30,10,20),(20,2,11)])
def test_WalletSummary(wallet,earned,spent,Total):

    wallet=wallet+earned

    wallet=wallet-spent

    assert wallet==Total




