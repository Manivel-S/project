import { test, expect } from '@playwright/test';

test(
  'CheckBUtton',
  {
    annotation: { type: 'QADENCE_TC_ID', description: 'TC-001' },
    tag: ['@QADENCE_TC_ID:TC-001'],
  },
  async ({ page }) => {


    await test.step('#01 - Navigate to https://www.saucedemo.com/', async () => {
      await page.goto('https://www.saucedemo.com/');
    });

    await test.step('#02 - Click on the Username textbox', async () => {
      await page.getByRole("textbox", { name: "Username", exact: true }).click();
    });

    await test.step('#03 - Enter \'standard_user\' in the Username textbox', async () => {
      await page.getByRole("textbox", { name: "Username", exact: true }).fill('standard_user');
    });

    await test.step('#04 - Click on the Password textbox', async () => {
      await page.getByRole("textbox", { name: "Password", exact: true }).click();
    });

    await test.step('#05 - Enter \'secret_sauce\' in the Password textbox', async () => {
      await page.getByRole("textbox", { name: "Password", exact: true }).fill('secret_sauce');
    });

    await test.step('#06 - Click the Login button', async () => {
      await page.getByRole("button", { name: "Login", exact: true }).click();
    });

    await test.step('#07 - Click on the first inventory item description (index 0)', async () => {
      await page.locator('[data-test="inventory-item-description"]').locator('[data-test="inventory-item-desc"]').nth(0).click();
    });

    await test.step('#08 - Click on the second inventory item description (index 1)', async () => {
      await page.locator('[data-test="inventory-item-description"]').locator('[data-test="inventory-item-desc"]').nth(1).click();
    });

    await test.step('#09 - Click on the third inventory item description (index 2)', async () => {
      await page.locator('[data-test="inventory-item-description"]').locator('[data-test="inventory-item-desc"]').nth(2).click();
    });

    await test.step('#10 - Click on the fourth inventory item description (index 3)', async () => {
      await page.locator('[data-test="inventory-item-description"]').locator('[data-test="inventory-item-desc"]').nth(3).click();
    });

    await test.step('#11 - Click on the fifth inventory item description (index 4)', async () => {
      await page.locator('[data-test="inventory-item-description"]').locator('[data-test="inventory-item-desc"]').nth(4).click();
    });

    await test.step('#12 - Click on the sixth inventory item description (index 5)', async () => {
      await page.locator('[data-test="inventory-item-description"]').locator('[data-test="inventory-item-desc"]').nth(5).click();
    });

    await test.step('#13 - Click the Open Menu button', async () => {
      await page.getByRole("button", { name: "Open Menu", exact: true }).click();
    });

    await test.step('#14 - Click the Logout button', async () => {
      await page.getByRole("button", { name: "Logout", exact: true }).click();
    });

    await test.step('#15 - Click on the main section containing \'LoginAccepted usernames\' text', async () => {
      await page.getByRole("main").filter({ hasText: "LoginAccepted usernames" }).click();
    });

  }
);

